package com.tesla.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.tesla.api.data.model.*;
import com.tesla.api.data.model.commands.CmdResponse;
import com.tesla.api.data.model.commands.CommandResponse;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Date;

public class JsonUtil {
    public static GsonBuilder gsonBuilder;

    static {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        gsonBuilder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
    }

    public static Gson getGson() {
        return gsonBuilder.create();
    }

    public static String serialize(Object obj){
        return getGson().toJson(obj);
    }

    public static Object deserialize(String json, String containerType, Class cls) {
        try{
            if("list".equalsIgnoreCase(containerType) || "array".equalsIgnoreCase(containerType)) {
                return JsonUtil.deserializeToList(json, cls);
            }
            else if(String.class.equals(cls)) {
                if(json != null && json.startsWith("\"") && json.endsWith("\"") && json.length() > 1)
                    return json.substring(1, json.length() - 1);
                else
                    return json;
            }
            else {
                return JsonUtil.deserializeToObject(json, cls);
            }
        }
        catch (JsonParseException e) {
            throw e;
        }
    }

    public static <T> T deserializeToList(String jsonString, Class cls){
        return getGson().fromJson(jsonString, getListTypeForDeserialization(cls));
    }

    public static <T> T deserializeToObject(String jsonString, Class cls){
        return getGson().fromJson(jsonString, getTypeForDeserialization(cls));
    }

    public static Type getListTypeForDeserialization(Class cls) {
        String className = cls.getSimpleName();
        return new TypeToken<List<Object>>(){}.getType();
    }

    public static Type getTypeForDeserialization(Class cls) {
        String className = cls.getSimpleName();

        if ("ChargeState".equalsIgnoreCase(className)) {
            return new TypeToken<ChargeState>(){}.getType();
        }

        if ("ClimateState".equalsIgnoreCase(className)) {
            return new TypeToken<ClimateState>(){}.getType();
        }

        if ("DriveState".equalsIgnoreCase(className)) {
            return new TypeToken<DriveState>(){}.getType();
        }

        if ("GuiState".equalsIgnoreCase(className)) {
            return new TypeToken<GuiState>(){}.getType();
        }

        if ("LoginSuccess".equalsIgnoreCase(className)) {
            return new TypeToken<LoginSuccess>(){}.getType();
        }

        if ("Vehicle".equalsIgnoreCase(className)) {
            return new TypeToken<Vehicle>(){}.getType();
        }

        if ("VehicleResponse".equalsIgnoreCase(className)) {
            return new TypeToken<VehicleResponse>(){}.getType();
        }

        if ("VehicleList".equalsIgnoreCase(className)) {
            return new TypeToken<VehicleList>(){}.getType();
        }

        if ("VehicleState".equalsIgnoreCase(className)) {
            return new TypeToken<VehicleState>(){}.getType();
        }

        if ("VehicleData".equalsIgnoreCase(className)) {
            return new TypeToken<VehicleData>(){}.getType();
        }

        if ("VehicleDataResponse".equalsIgnoreCase(className)) {
            return new TypeToken<VehicleDataResponse>(){}.getType();
        }

        if ("CommandResponse".equalsIgnoreCase(className)) {
            return new TypeToken<CommandResponse>(){}.getType();
        }

        if ("CmdResponse".equalsIgnoreCase(className)) {
            return new TypeToken<CmdResponse>(){}.getType();
        }

        return new TypeToken<Object>(){}.getType();
    }

};
