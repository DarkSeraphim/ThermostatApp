package com.example.thermostatapp.dto;

import com.example.thermostatapp.util.Serializable;
import org.thermostatapp.util.WeekProgram;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;

public class WeekProgramModel extends Serializable {
	public Boolean state = false;
	
	public String[] daysOfWeekStrings = new String[] {"Monday", "Tueseday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	public DayModel[] daysOfWeek = new DayModel[7];
	
	public WeekProgramModel(){
	}

    public static WeekProgramModel create() {
        WeekProgramModel model = new WeekProgramModel();
        for(int i = 0; i < model.daysOfWeekStrings.length; i++)
            model.daysOfWeek[i] = DayModel.create(model.daysOfWeekStrings[i]);
        return model;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeBoolean(this.state);
        out.writeShort(this.daysOfWeek.length);
        for(DayModel model : this.daysOfWeek)
            out.writeObject(model);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.state = in.readBoolean();
        short len = in.readShort();
        this.daysOfWeek = new DayModel[len];
        for(short s = 0; s < len; s++) {
            this.daysOfWeek[s] = (DayModel) in.readObject();
        }
    }

    private void readObjectNoData() throws ObjectStreamException
    {
        // TODO: handle this?
    }
}
