package com.example.thermostatapp.dto;

import com.example.thermostatapp.util.Serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;

public class SwitchModel extends Serializable{
	
	public SwitchType type;
	public boolean state;
	public String time;
	
	public static SwitchModel create(SwitchType type, boolean state, String time){
        SwitchModel model = new SwitchModel();
		model.type = type;
		model.state = state;
		model.time = time;
        return model;
	}

    private void writeObject(java.io.ObjectOutputStream out) throws IOException
    {
        writeString(out, type.name());
        out.writeBoolean(this.state);
        writeString(out, this.time);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        SwitchType.valueOf(readString(in));
        this.state = in.readBoolean();
        this.time = readString(in);
    }

    private void readObjectNoData() throws ObjectStreamException
    {
        // TODO: handle this?
    }
}
