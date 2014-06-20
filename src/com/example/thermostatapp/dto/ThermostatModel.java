package com.example.thermostatapp.dto;

import java.io.*;
import java.net.ConnectException;

import com.example.thermostatapp.util.*;
import org.thermostatapp.util.*;

public class ThermostatModel extends com.example.thermostatapp.util.Serializable{
	public String current_day;
	public String time;
	public String current_temperature;
	
	public String target_temperature;
	
	public String day_temperature;
	public String night_temperature;
	public String week_program_state;
	public WeekProgramModel weekProgram;
	
	protected ThermostatModel(){
        this.weekProgram = new WeekProgramModel();
	}

    private void init() {
        try {
            this.current_day = HeatingSystem.get("current_day");
            this.time = HeatingSystem.get("time");
            this.current_temperature = HeatingSystem.get("currentTemperature");
            this.day_temperature = HeatingSystem.get("day_temperature");
            this.night_temperature = HeatingSystem.get("target_temperature");
            this.weekProgram = new WeekProgramModel();
            this.week_program_state = HeatingSystem.get("weekProgramState");
        } catch (ConnectException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ThermostatModel create() {
        ThermostatModel model = new ThermostatModel();
        model.init();
        return model;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        writeString(out, this.current_day);
        writeString(out, this.time);
        writeString(out, this.current_temperature);
        writeString(out, this.target_temperature);
        writeString(out, this.day_temperature);
        writeString(out, this.night_temperature);
        writeString(out, this.week_program_state);
        out.writeObject(this.weekProgram);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.current_day = readString(in);
        this.time = readString(in);
        this.current_temperature = readString(in);
        this.target_temperature = readString(in);
        this.day_temperature = readString(in);
        this.night_temperature = readString(in);
        this.week_program_state = readString(in);
        this.weekProgram = (WeekProgramModel) in.readObject();
    }

    private void readObjectNoData() throws ObjectStreamException {
        // TODO: handle this?
    }

}
