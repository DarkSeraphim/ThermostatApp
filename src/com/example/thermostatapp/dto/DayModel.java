package com.example.thermostatapp.dto;

import android.Manifest.permission;
import android.app.admin.DeviceAdminInfo;
import com.example.thermostatapp.util.Serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;

public class DayModel extends Serializable{

	public String day;

    public SwitchModel[] switches = new SwitchModel[10];

	public static DayModel create(String name){
        DayModel model = new DayModel();
		model.day = name;
        for(int i = 0; i < 10; i++)
            model.switches[i] = SwitchModel.create(i < 5 ? SwitchType.night : SwitchType.day, false, "00:00");
        return model;
	}

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.writeShort(this.switches.length);
        for(SwitchModel model : this.switches)
            out.writeObject(model);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        short len = in.readShort();
        this.switches = new SwitchModel[len];
        for(short s = 0; s < len; s++) {
            this.switches[s] = (SwitchModel) in.readObject();
        }
    }

    private void readObjectNoData() throws ObjectStreamException {
        // TODO: handle this?
    }
}
