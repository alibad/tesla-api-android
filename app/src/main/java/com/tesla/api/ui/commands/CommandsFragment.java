package com.tesla.api.ui.commands;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.tesla.api.CtrlApp;
import com.tesla.api.R;
import com.tesla.api.data.Result;
import com.tesla.api.data.TeslaAPIWrapper;
import com.tesla.api.data.model.commands.CmdResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CommandsFragment extends Fragment {

    private CommandsViewModel dashboardViewModel;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(CommandsViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_commands, container, false);

        final String dialogMessage = "Make sure no one is actively driving the car!";

        CmdInfo unlockDoorCmdInfo = new CmdInfo();
        unlockDoorCmdInfo.ButtonId = R.id.unlock_door_button;
        unlockDoorCmdInfo.ApiMethodName = "door_unlock";
        unlockDoorCmdInfo.DialogInfo = new CmdDialogInfo();
        unlockDoorCmdInfo.DialogInfo.Title = "Are you sure you want to unlock door?";
        unlockDoorCmdInfo.DialogInfo.Message = dialogMessage;
        unlockDoorCmdInfo.DialogInfo.SuccessMessage = "Door unlocked!";
        unlockDoorCmdInfo.DialogInfo.FailureMessage = "Could not unlock door!";
        unlockDoorCmdInfo.DialogInfo.ErrorMessage = "Error making request to unlock door";
        unlockDoorCmdInfo.DialogInfo.CancelMessage = "Ok, door will not be unlocked";
        setupCommandButton(inflater, root, unlockDoorCmdInfo);

        CmdInfo lockDoorCmdInfo = new CmdInfo();
        lockDoorCmdInfo.ButtonId = R.id.lock_door_button;
        lockDoorCmdInfo.ApiMethodName = "door_lock";
        lockDoorCmdInfo.DialogInfo = new CmdDialogInfo();
        lockDoorCmdInfo.DialogInfo.Title = "Are you sure you want to lock door?";
        lockDoorCmdInfo.DialogInfo.Message = dialogMessage;
        lockDoorCmdInfo.DialogInfo.SuccessMessage = "Door locked!";
        lockDoorCmdInfo.DialogInfo.FailureMessage = "Could not lock door!";
        lockDoorCmdInfo.DialogInfo.ErrorMessage = "Error making request to lock door";
        lockDoorCmdInfo.DialogInfo.CancelMessage = "Ok, door will not be locked";
        setupCommandButton(inflater, root, lockDoorCmdInfo);

        CmdInfo actuateTrunkCmdInfo = new CmdInfo();
        actuateTrunkCmdInfo.ButtonId = R.id.actuate_trunk_button;
        actuateTrunkCmdInfo.ApiMethodName = "actuate_trunk";
        actuateTrunkCmdInfo.DialogInfo = new CmdDialogInfo();
        actuateTrunkCmdInfo.DialogInfo.Title = "Are you sure you want to send open trunk request?";
        actuateTrunkCmdInfo.DialogInfo.Message = dialogMessage;
        actuateTrunkCmdInfo.DialogInfo.SuccessMessage = "Open trunk request sent!";
        actuateTrunkCmdInfo.DialogInfo.FailureMessage = "Could not send open trunk request!";
        actuateTrunkCmdInfo.DialogInfo.ErrorMessage = "Error making request to open trunk";
        actuateTrunkCmdInfo.DialogInfo.CancelMessage = "Ok, open trunk request will not be sent";
        setupCommandButton(inflater, root, actuateTrunkCmdInfo);

        actuateTrunkCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        actuateTrunkCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_actuate_trunk;
        actuateTrunkCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        CmdDialogParamInfo param = new CmdDialogParamInfo();
        param.EditTextId = R.id.which_trunk_edit_text;
        param.Name = "which_trunk";
        actuateTrunkCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, actuateTrunkCmdInfo);

        CmdInfo honkHornCmdInfo = new CmdInfo();
        honkHornCmdInfo.ButtonId = R.id.honk_horn_button;
        honkHornCmdInfo.ApiMethodName = "honk_horn";
        honkHornCmdInfo.DialogInfo = new CmdDialogInfo();
        honkHornCmdInfo.DialogInfo.Title = "Are you sure you want to honk horn?";
        honkHornCmdInfo.DialogInfo.Message = dialogMessage;
        honkHornCmdInfo.DialogInfo.SuccessMessage = "Honked horn!";
        honkHornCmdInfo.DialogInfo.FailureMessage = "Could not honk horn!";
        honkHornCmdInfo.DialogInfo.ErrorMessage = "Error making request to honk horn";
        honkHornCmdInfo.DialogInfo.CancelMessage = "Ok, horn will not be honked";
        setupCommandButton(inflater, root, honkHornCmdInfo);

        CmdInfo flashLightsCmdInfo = new CmdInfo();
        flashLightsCmdInfo.ButtonId = R.id.flash_lights_button;
        flashLightsCmdInfo.ApiMethodName = "flash_lights";
        flashLightsCmdInfo.DialogInfo = new CmdDialogInfo();
        flashLightsCmdInfo.DialogInfo.Title = "Are you sure you want to flash lights?";
        flashLightsCmdInfo.DialogInfo.Message = dialogMessage;
        flashLightsCmdInfo.DialogInfo.SuccessMessage = "Lights flashed!";
        flashLightsCmdInfo.DialogInfo.FailureMessage = "Could not flash lights!";
        flashLightsCmdInfo.DialogInfo.ErrorMessage = "Error making request to flash lights";
        flashLightsCmdInfo.DialogInfo.CancelMessage = "Ok, lights will not be flashed";
        setupCommandButton(inflater, root, flashLightsCmdInfo);

        CmdInfo autoConditioningStartCmdInfo = new CmdInfo();
        autoConditioningStartCmdInfo.ButtonId = R.id.start_hvac_system_button;
        autoConditioningStartCmdInfo.ApiMethodName = "auto_conditioning_start";
        autoConditioningStartCmdInfo.DialogInfo = new CmdDialogInfo();
        autoConditioningStartCmdInfo.DialogInfo.Title = "Are you sure you want to start HVAC System?";
        autoConditioningStartCmdInfo.DialogInfo.Message = dialogMessage;
        autoConditioningStartCmdInfo.DialogInfo.SuccessMessage = "HVAC System started!";
        autoConditioningStartCmdInfo.DialogInfo.FailureMessage = "Could not start HVAC System!";
        autoConditioningStartCmdInfo.DialogInfo.ErrorMessage = "Error making request to start HVAC System";
        autoConditioningStartCmdInfo.DialogInfo.CancelMessage = "Ok, HVAC System will not be started";
        setupCommandButton(inflater, root, autoConditioningStartCmdInfo);

        CmdInfo autoConditioningStopCmdInfo = new CmdInfo();
        autoConditioningStopCmdInfo.ButtonId = R.id.stop_hvac_system_button;
        autoConditioningStopCmdInfo.ApiMethodName = "auto_conditioning_stop";
        autoConditioningStopCmdInfo.DialogInfo = new CmdDialogInfo();
        autoConditioningStopCmdInfo.DialogInfo.Title = "Are you sure you want to stop HVAC System?";
        autoConditioningStopCmdInfo.DialogInfo.Message = dialogMessage;
        autoConditioningStopCmdInfo.DialogInfo.SuccessMessage = "HVAC System stopped!";
        autoConditioningStopCmdInfo.DialogInfo.FailureMessage = "Could not stop HVAC System!";
        autoConditioningStopCmdInfo.DialogInfo.ErrorMessage = "Error making request to stop HVAC System";
        autoConditioningStopCmdInfo.DialogInfo.CancelMessage = "Ok, HVAC System will not be stopped";
        setupCommandButton(inflater, root, autoConditioningStopCmdInfo);

        CmdInfo setTempsCmdInfo = new CmdInfo();
        setTempsCmdInfo.ButtonId = R.id.set_temperature_button;
        setTempsCmdInfo.ApiMethodName = "set_temps";
        setTempsCmdInfo.DialogInfo = new CmdDialogInfo();
        setTempsCmdInfo.DialogInfo.Title = "Are you sure you want to change the temperature?";
        setTempsCmdInfo.DialogInfo.Message = dialogMessage;
        setTempsCmdInfo.DialogInfo.SuccessMessage = "Temperature changed!";
        setTempsCmdInfo.DialogInfo.FailureMessage = "Could not change temperature!";
        setTempsCmdInfo.DialogInfo.ErrorMessage = "Error making request to change temperature";
        setTempsCmdInfo.DialogInfo.CancelMessage = "Ok, temperature will not be changed";

        setTempsCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        setTempsCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_set_temps;
        setTempsCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.driver_temp_Edit_text;
        param.Name = "driver_temp";
        setTempsCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.passenger_temp_edit_text;
        param.Name = "passenger_temp";
        setTempsCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, setTempsCmdInfo);

        CmdInfo setPreconditioningMax = new CmdInfo();
        setPreconditioningMax.ButtonId = R.id.set_preconditioning_max_button;
        setPreconditioningMax.ApiMethodName = "set_preconditioning_max";
        setPreconditioningMax.DialogInfo = new CmdDialogInfo();
        setPreconditioningMax.DialogInfo.Title = "Are you sure you want to set preconditioning to max?";
        setPreconditioningMax.DialogInfo.Message = dialogMessage;
        setPreconditioningMax.DialogInfo.SuccessMessage = "Changed preconditioning!";
        setPreconditioningMax.DialogInfo.FailureMessage = "Could not change preconditioning!";
        setPreconditioningMax.DialogInfo.ErrorMessage = "Error making request to change preconditioning";
        setPreconditioningMax.DialogInfo.CancelMessage = "Ok, preconditioning will not be changed";
        setupCommandButton(inflater, root, setPreconditioningMax);

        setPreconditioningMax.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        setPreconditioningMax.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_set_preconditioning_max;
        setPreconditioningMax.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.set_preconditioning_max_edit_text;
        param.Name = "on";
        setPreconditioningMax.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, setPreconditioningMax);

        CmdInfo remoteSeatHeaterRequest = new CmdInfo();
        remoteSeatHeaterRequest.ButtonId = R.id.remote_seat_heater_request_button;
        remoteSeatHeaterRequest.ApiMethodName = "remote_seat_heater_request";
        remoteSeatHeaterRequest.DialogInfo = new CmdDialogInfo();
        remoteSeatHeaterRequest.DialogInfo.Title = "Are you sure you want to send remote seat heater request?";
        remoteSeatHeaterRequest.DialogInfo.Message = dialogMessage;
        remoteSeatHeaterRequest.DialogInfo.SuccessMessage = "Remote seat heater request sent!";
        remoteSeatHeaterRequest.DialogInfo.FailureMessage = "Could not send remote seat heater request!";
        remoteSeatHeaterRequest.DialogInfo.ErrorMessage = "Error making request to set seat heater";
        remoteSeatHeaterRequest.DialogInfo.CancelMessage = "Ok, seat heater request will not be sent";
        setupCommandButton(inflater, root, remoteSeatHeaterRequest);

        remoteSeatHeaterRequest.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        remoteSeatHeaterRequest.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_set_seat_heater;
        remoteSeatHeaterRequest.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.seat_position_edit_text;
        param.Name = "heater";
        remoteSeatHeaterRequest.DialogInfo.ParamsInfo.Parameters.add(param);
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.seat_heater_numeric_setting_edit_text;
        param.Name = "level";
        remoteSeatHeaterRequest.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, setTempsCmdInfo);

        CmdInfo remoteSteeringWheelHeaterRequest = new CmdInfo();
        remoteSteeringWheelHeaterRequest.ButtonId = R.id.remote_steering_wheel_heater_request_button;
        remoteSteeringWheelHeaterRequest.ApiMethodName = "remote_steering_wheel_heater_request";
        remoteSteeringWheelHeaterRequest.DialogInfo = new CmdDialogInfo();
        remoteSteeringWheelHeaterRequest.DialogInfo.Title = "Are you sure you want to remotely activate steering wheel heater?";
        remoteSteeringWheelHeaterRequest.DialogInfo.Message = dialogMessage;
        remoteSteeringWheelHeaterRequest.DialogInfo.SuccessMessage = "Sending request for steering wheel heater!";
        remoteSteeringWheelHeaterRequest.DialogInfo.FailureMessage = "Could not remotely activate steering wheel heater!";
        remoteSteeringWheelHeaterRequest.DialogInfo.ErrorMessage = "Error remotely activating steering wheel heater";
        remoteSteeringWheelHeaterRequest.DialogInfo.CancelMessage = "Ok, request to remotely activate steering wheel heater will be cancelled";
        setupCommandButton(inflater, root, remoteSteeringWheelHeaterRequest);

        CmdInfo setChargeLimitCmdInfo = new CmdInfo();
        setChargeLimitCmdInfo.ButtonId = R.id.set_charge_limit_button;
        setChargeLimitCmdInfo.ApiMethodName = "set_charge_limit";
        setChargeLimitCmdInfo.DialogInfo = new CmdDialogInfo();
        setChargeLimitCmdInfo.DialogInfo.Title = "Are you sure you want to set the charge limit?";
        setChargeLimitCmdInfo.DialogInfo.Message = dialogMessage;
        setChargeLimitCmdInfo.DialogInfo.SuccessMessage = "Charge Limit changed!";
        setChargeLimitCmdInfo.DialogInfo.FailureMessage = "Could not set the charge limit!";
        setChargeLimitCmdInfo.DialogInfo.ErrorMessage = "Error making request to set the charge limit";
        setChargeLimitCmdInfo.DialogInfo.CancelMessage = "Ok, Charge limit will not be changed";

        setChargeLimitCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        setChargeLimitCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_set_charge_limit;
        setChargeLimitCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.charge_limit_edit_text;
        param.Name = "percent";
        setChargeLimitCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, setChargeLimitCmdInfo);

        CmdInfo setMaxRangeChargeLimitCmdInfo = new CmdInfo();
        setMaxRangeChargeLimitCmdInfo.ButtonId = R.id.set_max_range_charge_limit_button;
        setMaxRangeChargeLimitCmdInfo.ApiMethodName = "charge_max_range";
        setMaxRangeChargeLimitCmdInfo.DialogInfo = new CmdDialogInfo();
        setMaxRangeChargeLimitCmdInfo.DialogInfo.Title = "Are you sure you want to set the charge limit to max range?";
        setMaxRangeChargeLimitCmdInfo.DialogInfo.Message = dialogMessage;
        setMaxRangeChargeLimitCmdInfo.DialogInfo.SuccessMessage = "Charge Limit set to max range!";
        setMaxRangeChargeLimitCmdInfo.DialogInfo.FailureMessage = "Could not set the charge limit to max range!";
        setMaxRangeChargeLimitCmdInfo.DialogInfo.ErrorMessage = "Error making request to set the charge limit to max range";
        setMaxRangeChargeLimitCmdInfo.DialogInfo.CancelMessage = "Ok, Charge limit will not be set to max range";
        setupCommandButton(inflater, root, setMaxRangeChargeLimitCmdInfo);

        CmdInfo setChargeLimitToStandardCmdInfo = new CmdInfo();
        setChargeLimitToStandardCmdInfo.ButtonId = R.id.set_standard_charge_limit_button;
        setChargeLimitToStandardCmdInfo.ApiMethodName = "charge_standard";
        setChargeLimitToStandardCmdInfo.DialogInfo = new CmdDialogInfo();
        setChargeLimitToStandardCmdInfo.DialogInfo.Title = "Are you sure you want to set the charge limit to standard?";
        setChargeLimitToStandardCmdInfo.DialogInfo.Message = dialogMessage;
        setChargeLimitToStandardCmdInfo.DialogInfo.SuccessMessage = "Charge Limit set to standard!";
        setChargeLimitToStandardCmdInfo.DialogInfo.FailureMessage = "Could not set charge limit to standard!";
        setChargeLimitToStandardCmdInfo.DialogInfo.ErrorMessage = "Error making request to set the charge limit to standard";
        setChargeLimitToStandardCmdInfo.DialogInfo.CancelMessage = "Ok, Charge limit will not be set to standard";
        setupCommandButton(inflater, root, setChargeLimitToStandardCmdInfo);

        CmdInfo startRemoteDriveCmdInfo = new CmdInfo();
        startRemoteDriveCmdInfo.ButtonId = R.id.remote_start_drive_button;
        startRemoteDriveCmdInfo.ApiMethodName = "remote_start_drive";
        startRemoteDriveCmdInfo.DialogInfo = new CmdDialogInfo();
        startRemoteDriveCmdInfo.DialogInfo.Title = "Are you sure you want to start the car for keyless driving?";
        startRemoteDriveCmdInfo.DialogInfo.Message = dialogMessage;
        startRemoteDriveCmdInfo.DialogInfo.SuccessMessage = "Car started for keyless driving. Must start driving within 2 minutes of issuing this request.";
        startRemoteDriveCmdInfo.DialogInfo.FailureMessage = "Could not start keyless driving!";
        startRemoteDriveCmdInfo.DialogInfo.ErrorMessage = "Error making request to remote start drive";
        startRemoteDriveCmdInfo.DialogInfo.CancelMessage = "Ok, Won't start keyless driving";

        startRemoteDriveCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        startRemoteDriveCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_remote_start_drive;
        startRemoteDriveCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.password_edit_text;
        param.Name = "password";
        startRemoteDriveCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, startRemoteDriveCmdInfo);

        CmdInfo chargePortDoorOpenCmdInfo = new CmdInfo();
        chargePortDoorOpenCmdInfo.ButtonId = R.id.open_charge_port_button;
        chargePortDoorOpenCmdInfo.ApiMethodName = "charge_port_door_open";
        chargePortDoorOpenCmdInfo.DialogInfo = new CmdDialogInfo();
        chargePortDoorOpenCmdInfo.DialogInfo.Title = "Are you sure you want to open charge port door?";
        chargePortDoorOpenCmdInfo.DialogInfo.Message = dialogMessage;
        chargePortDoorOpenCmdInfo.DialogInfo.SuccessMessage = "Charge port door opened!";
        chargePortDoorOpenCmdInfo.DialogInfo.FailureMessage = "Could not open Charge port door!";
        chargePortDoorOpenCmdInfo.DialogInfo.ErrorMessage = "Error making request to open Charge port door";
        chargePortDoorOpenCmdInfo.DialogInfo.CancelMessage = "Ok, Charge port door will not be opened";
        setupCommandButton(inflater, root, chargePortDoorOpenCmdInfo);

        CmdInfo chargePortDoorCloseCmdInfo = new CmdInfo();
        chargePortDoorCloseCmdInfo.ButtonId = R.id.close_charge_port_button;
        chargePortDoorCloseCmdInfo.ApiMethodName = "charge_port_door_close";
        chargePortDoorCloseCmdInfo.DialogInfo = new CmdDialogInfo();
        chargePortDoorCloseCmdInfo.DialogInfo.Title = "Are you sure you want to close charge port door?";
        chargePortDoorCloseCmdInfo.DialogInfo.Message = dialogMessage;
        chargePortDoorCloseCmdInfo.DialogInfo.SuccessMessage = "Charge port door closed!";
        chargePortDoorCloseCmdInfo.DialogInfo.FailureMessage = "Could not close Charge port door!";
        chargePortDoorCloseCmdInfo.DialogInfo.ErrorMessage = "Error making request to close Charge port door";
        chargePortDoorCloseCmdInfo.DialogInfo.CancelMessage = "Ok, Charge port door will not be closed";
        setupCommandButton(inflater, root, chargePortDoorCloseCmdInfo);

        CmdInfo chargeStartCmdInfo = new CmdInfo();
        chargeStartCmdInfo.ButtonId = R.id.start_charging_button;
        chargeStartCmdInfo.ApiMethodName = "charge_start";
        chargeStartCmdInfo.DialogInfo = new CmdDialogInfo();
        chargeStartCmdInfo.DialogInfo.Title = "Are you sure you want to start charging?";
        chargeStartCmdInfo.DialogInfo.Message = dialogMessage;
        chargeStartCmdInfo.DialogInfo.SuccessMessage = "If the car is plugged in but not currently charging, this will start it charging!";
        chargeStartCmdInfo.DialogInfo.FailureMessage = "Could not start charging!";
        chargeStartCmdInfo.DialogInfo.ErrorMessage = "Error making request to start charging";
        chargeStartCmdInfo.DialogInfo.CancelMessage = "Ok, will not start charging";
        setupCommandButton(inflater, root, chargeStartCmdInfo);

        CmdInfo chargeStopCmdInfo = new CmdInfo();
        chargeStopCmdInfo.ButtonId = R.id.stop_charging_button;
        chargeStopCmdInfo.ApiMethodName = "charge_stop";
        chargeStopCmdInfo.DialogInfo = new CmdDialogInfo();
        chargeStopCmdInfo.DialogInfo.Title = "Are you sure you want to stop charging?";
        chargeStopCmdInfo.DialogInfo.Message = dialogMessage;
        chargeStopCmdInfo.DialogInfo.SuccessMessage = "If the car is currently charging, this will stop it!";
        chargeStopCmdInfo.DialogInfo.FailureMessage = "Could not stop charging!";
        chargeStopCmdInfo.DialogInfo.ErrorMessage = "Error making request to stop charging";
        chargeStopCmdInfo.DialogInfo.CancelMessage = "Ok, will not stop charging";
        setupCommandButton(inflater, root, chargeStopCmdInfo);

        CmdInfo setSentryModeCmdInfo = new CmdInfo();
        setSentryModeCmdInfo.ButtonId = R.id.set_sentry_mode_button;
        setSentryModeCmdInfo.ApiMethodName = "set_sentry_mode";
        setSentryModeCmdInfo.DialogInfo = new CmdDialogInfo();
        setSentryModeCmdInfo.DialogInfo.Title = "Are you sure you want to set sentry mode?";
        setSentryModeCmdInfo.DialogInfo.Message = dialogMessage;
        setSentryModeCmdInfo.DialogInfo.SuccessMessage = "Sentry mode changed!";
        setSentryModeCmdInfo.DialogInfo.FailureMessage = "Could not set sentry mode!";
        setSentryModeCmdInfo.DialogInfo.ErrorMessage = "Error making request to set sentry mode";
        setSentryModeCmdInfo.DialogInfo.CancelMessage = "Ok, Sentry mode will not be changed";

        setSentryModeCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        setSentryModeCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_set_sentry_mode;
        setSentryModeCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.sentry_mode_edit_text;
        param.Name = "on";
        setSentryModeCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, setSentryModeCmdInfo);

        CmdInfo setValetModeCmdInfo = new CmdInfo();
        setValetModeCmdInfo.ButtonId = R.id.set_valet_mode_button;
        setValetModeCmdInfo.ApiMethodName = "set_valet_mode";
        setValetModeCmdInfo.DialogInfo = new CmdDialogInfo();
        setValetModeCmdInfo.DialogInfo.Title = "Are you sure you want to set valet mode?";
        setValetModeCmdInfo.DialogInfo.Message = dialogMessage;
        setValetModeCmdInfo.DialogInfo.SuccessMessage = "Sentry mode changed!";
        setValetModeCmdInfo.DialogInfo.FailureMessage = "Could not set valet mode!";
        setValetModeCmdInfo.DialogInfo.ErrorMessage = "Error making request to set valet mode";
        setValetModeCmdInfo.DialogInfo.CancelMessage = "Ok, Valet mode will not be changed";

        setValetModeCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        setValetModeCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_set_valet_mode;
        setValetModeCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.valet_mode_on_edit_text;
        param.Name = "on";
        setValetModeCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.valet_mode_pin_edit_text;
        param.Name = "password";
        setValetModeCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, setValetModeCmdInfo);

        CmdInfo resetValetPinCmdInfo = new CmdInfo();
        resetValetPinCmdInfo.ButtonId = R.id.reset_valet_pin_button;
        resetValetPinCmdInfo.ApiMethodName = "reset_valet_pin";
        resetValetPinCmdInfo.DialogInfo = new CmdDialogInfo();
        resetValetPinCmdInfo.DialogInfo.Title = "Are you sure you want to reset valet pin?";
        resetValetPinCmdInfo.DialogInfo.Message = dialogMessage;
        resetValetPinCmdInfo.DialogInfo.SuccessMessage = "Cleared the currently set PIN for Valet Mode!";
        resetValetPinCmdInfo.DialogInfo.FailureMessage = "Could not reset valet pin!";
        resetValetPinCmdInfo.DialogInfo.ErrorMessage = "Error making request to reset valet pin";
        resetValetPinCmdInfo.DialogInfo.CancelMessage = "Ok, will not reset valet pin";
        setupCommandButton(inflater, root, resetValetPinCmdInfo);

        CmdInfo setSpeedLimitCmdInfo = new CmdInfo();
        setSpeedLimitCmdInfo.ButtonId = R.id.speed_limit_set_limit_button;
        setSpeedLimitCmdInfo.ApiMethodName = "speed_limit_set_limit";
        setSpeedLimitCmdInfo.DialogInfo = new CmdDialogInfo();
        setSpeedLimitCmdInfo.DialogInfo.Title = "Are you sure you want to set speed limit?";
        setSpeedLimitCmdInfo.DialogInfo.Message = dialogMessage;
        setSpeedLimitCmdInfo.DialogInfo.SuccessMessage = "Speed limit changed!";
        setSpeedLimitCmdInfo.DialogInfo.FailureMessage = "Could not set speed limit!";
        setSpeedLimitCmdInfo.DialogInfo.ErrorMessage = "Error making request to set speed limit";
        setSpeedLimitCmdInfo.DialogInfo.CancelMessage = "Ok, Speed limit will not be changed";

        setSpeedLimitCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        setSpeedLimitCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_set_speed_limit;
        setSpeedLimitCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.limit_mph_edit_text;
        param.Name = "limit_mph";
        setSpeedLimitCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, setSpeedLimitCmdInfo);

        CmdInfo speedLimitActivateCmdInfo = new CmdInfo();
        speedLimitActivateCmdInfo.ButtonId = R.id.speed_limit_activate_button;
        speedLimitActivateCmdInfo.ApiMethodName = "speed_limit_activate";
        speedLimitActivateCmdInfo.DialogInfo = new CmdDialogInfo();
        speedLimitActivateCmdInfo.DialogInfo.Title = "Are you sure you want to activate speed limit mode at the currently set speed?";
        speedLimitActivateCmdInfo.DialogInfo.Message = dialogMessage;
        speedLimitActivateCmdInfo.DialogInfo.SuccessMessage = "Speed limit mode activated!";
        speedLimitActivateCmdInfo.DialogInfo.FailureMessage = "Could not activate speed limit mode!";
        speedLimitActivateCmdInfo.DialogInfo.ErrorMessage = "Error making request to activate speed limit mode";
        speedLimitActivateCmdInfo.DialogInfo.CancelMessage = "Ok, Speed limit mode will not be activated";

        speedLimitActivateCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        speedLimitActivateCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_speed_limit_activate;
        speedLimitActivateCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.speed_limit_activate_pin_edit_text;
        param.Name = "pin";
        speedLimitActivateCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, speedLimitActivateCmdInfo);

        CmdInfo speedLimitDeactivateCmdInfo = new CmdInfo();
        speedLimitDeactivateCmdInfo.ButtonId = R.id.speed_limit_deactivate_button;
        speedLimitDeactivateCmdInfo.ApiMethodName = "speed_limit_deactivate";
        speedLimitDeactivateCmdInfo.DialogInfo = new CmdDialogInfo();
        speedLimitDeactivateCmdInfo.DialogInfo.Title = "Are you sure you want to deactivate speed limit mode?";
        speedLimitDeactivateCmdInfo.DialogInfo.Message = dialogMessage;
        speedLimitDeactivateCmdInfo.DialogInfo.SuccessMessage = "Speed limit mode deactivated!";
        speedLimitDeactivateCmdInfo.DialogInfo.FailureMessage = "Could not deactivate speed limit mode!";
        speedLimitDeactivateCmdInfo.DialogInfo.ErrorMessage = "Error making request to deactivate speed limit mode";
        speedLimitDeactivateCmdInfo.DialogInfo.CancelMessage = "Ok, Speed limit mode will not be deactivated";

        speedLimitDeactivateCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        speedLimitDeactivateCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_speed_limit_deactivate;
        speedLimitDeactivateCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.speed_limit_deactivate_pin_edit_text;
        param.Name = "pin";
        speedLimitDeactivateCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, speedLimitDeactivateCmdInfo);

        CmdInfo resetSpeedLimitPinCmdInfo = new CmdInfo();
        resetSpeedLimitPinCmdInfo.ButtonId = R.id.speed_limit_clear_pin_button;
        resetSpeedLimitPinCmdInfo.ApiMethodName = "speed_limit_clear_pin";
        resetSpeedLimitPinCmdInfo.DialogInfo = new CmdDialogInfo();
        resetSpeedLimitPinCmdInfo.DialogInfo.Title = "Are you sure you want to clear the currently set PIN for Speed Limit Mode?";
        resetSpeedLimitPinCmdInfo.DialogInfo.Message = dialogMessage;
        resetSpeedLimitPinCmdInfo.DialogInfo.SuccessMessage = "Cleared the currently set PIN for Speed Limit Mode!";
        resetSpeedLimitPinCmdInfo.DialogInfo.FailureMessage = "Could not reset pin for Speed Limit mode!";
        resetSpeedLimitPinCmdInfo.DialogInfo.ErrorMessage = "Error making request to reset pin for Speed Limit mode";
        resetSpeedLimitPinCmdInfo.DialogInfo.CancelMessage = "Ok, will not reset pin for Speed Limit mode";

        resetSpeedLimitPinCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        resetSpeedLimitPinCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_speed_limit_clear_pin;
        resetSpeedLimitPinCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.speed_limit_clear_pin_edit_text;
        param.Name = "pin";
        resetSpeedLimitPinCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, resetSpeedLimitPinCmdInfo);

        CmdInfo windowControlCmdInfo = new CmdInfo();
        windowControlCmdInfo.ButtonId = R.id.window_control_button;
        windowControlCmdInfo.ApiMethodName = "window_control";
        windowControlCmdInfo.DialogInfo = new CmdDialogInfo();
        windowControlCmdInfo.DialogInfo.Title = "Are you sure you want to close or vent window?";
        windowControlCmdInfo.DialogInfo.Message = dialogMessage;
        windowControlCmdInfo.DialogInfo.SuccessMessage = "Windows vented or closed!";
        windowControlCmdInfo.DialogInfo.FailureMessage = "Could not close or vent windows!";
        windowControlCmdInfo.DialogInfo.ErrorMessage = "Error making request to close or vent windows";
        windowControlCmdInfo.DialogInfo.CancelMessage = "Ok, Windows will not be closed or vented";

        windowControlCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        windowControlCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_window_control;
        windowControlCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.window_control_command_edit_text;
        param.Name = "command";
        windowControlCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.window_control_latitude_edit_text;
        param.Name = "lat";
        windowControlCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.window_control_longitude_edit_text;
        param.Name = "lon";
        windowControlCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, windowControlCmdInfo);

        CmdInfo sunRoofControl = new CmdInfo();
        sunRoofControl.ButtonId = R.id.sun_roof_control_button;
        sunRoofControl.ApiMethodName = "sun_roof_control";
        sunRoofControl.DialogInfo = new CmdDialogInfo();
        sunRoofControl.DialogInfo.Title = "Are you sure you want to send sun roof control request?";
        sunRoofControl.DialogInfo.Message = dialogMessage;
        sunRoofControl.DialogInfo.SuccessMessage = "Sun roof control request sent!";
        sunRoofControl.DialogInfo.FailureMessage = "Could not send sun roof control request!";
        sunRoofControl.DialogInfo.ErrorMessage = "Error making request to control sunroof";
        sunRoofControl.DialogInfo.CancelMessage = "Ok, sun roof control request will not be sent";
        setupCommandButton(inflater, root, sunRoofControl);

        sunRoofControl.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        sunRoofControl.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_sun_roof_control;
        sunRoofControl.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.sun_roof_state_edit_text;
        param.Name = "open or closed";
        sunRoofControl.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, sunRoofControl);

        CmdInfo mediaTogglePlaybackCmdInfo = new CmdInfo();
        mediaTogglePlaybackCmdInfo.ButtonId = R.id.media_toggle_playback_button;
        mediaTogglePlaybackCmdInfo.ApiMethodName = "media_toggle_playback";
        mediaTogglePlaybackCmdInfo.DialogInfo = new CmdDialogInfo();
        mediaTogglePlaybackCmdInfo.DialogInfo.Title = "Are you sure you want to toggle media playback?";
        mediaTogglePlaybackCmdInfo.DialogInfo.Message = dialogMessage;
        mediaTogglePlaybackCmdInfo.DialogInfo.SuccessMessage = "Media playback toggled!";
        mediaTogglePlaybackCmdInfo.DialogInfo.FailureMessage = "Could not toggle media playback!";
        mediaTogglePlaybackCmdInfo.DialogInfo.ErrorMessage = "Error making request to toggle media playback";
        mediaTogglePlaybackCmdInfo.DialogInfo.CancelMessage = "Ok, won't toggle media playback";
        setupCommandButton(inflater, root, mediaTogglePlaybackCmdInfo);

        CmdInfo mediaNextTrackCmdInfo = new CmdInfo();
        mediaNextTrackCmdInfo.ButtonId = R.id.media_next_track_button;
        mediaNextTrackCmdInfo.ApiMethodName = "media_next_track";
        mediaNextTrackCmdInfo.DialogInfo = new CmdDialogInfo();
        mediaNextTrackCmdInfo.DialogInfo.Title = "Are you sure you want to go to next track?";
        mediaNextTrackCmdInfo.DialogInfo.Message = dialogMessage;
        mediaNextTrackCmdInfo.DialogInfo.SuccessMessage = "Next track!";
        mediaNextTrackCmdInfo.DialogInfo.FailureMessage = "Could not go to next track!";
        mediaNextTrackCmdInfo.DialogInfo.ErrorMessage = "Error making request to go to next track";
        mediaNextTrackCmdInfo.DialogInfo.CancelMessage = "Ok, won't go to next track";
        setupCommandButton(inflater, root, mediaNextTrackCmdInfo);

        CmdInfo mediaPrevTrackCmdInfo = new CmdInfo();
        mediaPrevTrackCmdInfo.ButtonId = R.id.media_prev_track_button;
        mediaPrevTrackCmdInfo.ApiMethodName = "media_prev_track";
        mediaPrevTrackCmdInfo.DialogInfo = new CmdDialogInfo();
        mediaPrevTrackCmdInfo.DialogInfo.Title = "Are you sure you want to go to previous track?";
        mediaPrevTrackCmdInfo.DialogInfo.Message = dialogMessage;
        mediaPrevTrackCmdInfo.DialogInfo.SuccessMessage = "Previous track!";
        mediaPrevTrackCmdInfo.DialogInfo.FailureMessage = "Could not go to previous track!";
        mediaPrevTrackCmdInfo.DialogInfo.ErrorMessage = "Error making request to go to previous track";
        mediaPrevTrackCmdInfo.DialogInfo.CancelMessage = "Ok, won't go to previous track";
        setupCommandButton(inflater, root, mediaPrevTrackCmdInfo);

        CmdInfo mediaNextFavCmdInfo = new CmdInfo();
        mediaNextFavCmdInfo.ButtonId = R.id.media_next_fav_button;
        mediaNextFavCmdInfo.ApiMethodName = "media_next_fav";
        mediaNextFavCmdInfo.DialogInfo = new CmdDialogInfo();
        mediaNextFavCmdInfo.DialogInfo.Title = "Are you sure you want to go to next favorite?";
        mediaNextFavCmdInfo.DialogInfo.Message = dialogMessage;
        mediaNextFavCmdInfo.DialogInfo.SuccessMessage = "Next favorite!";
        mediaNextFavCmdInfo.DialogInfo.FailureMessage = "Could not go to next favorite!";
        mediaNextFavCmdInfo.DialogInfo.ErrorMessage = "Error making request to go to next favorite";
        mediaNextFavCmdInfo.DialogInfo.CancelMessage = "Ok, won't go to next favorite";
        setupCommandButton(inflater, root, mediaNextFavCmdInfo);

        CmdInfo mediaPrevFavCmdInfo = new CmdInfo();
        mediaPrevFavCmdInfo.ButtonId = R.id.media_prev_fav_button;
        mediaPrevFavCmdInfo.ApiMethodName = "media_prev_fav";
        mediaPrevFavCmdInfo.DialogInfo = new CmdDialogInfo();
        mediaPrevFavCmdInfo.DialogInfo.Title = "Are you sure you want to go to previous favorite?";
        mediaPrevFavCmdInfo.DialogInfo.Message = dialogMessage;
        mediaPrevFavCmdInfo.DialogInfo.SuccessMessage = "Previous favorite!";
        mediaPrevFavCmdInfo.DialogInfo.FailureMessage = "Could not go to previous favorite!";
        mediaPrevFavCmdInfo.DialogInfo.ErrorMessage = "Error making request to go to previous favorite";
        mediaPrevFavCmdInfo.DialogInfo.CancelMessage = "Ok, won't go to previous favorite";
        setupCommandButton(inflater, root, mediaPrevFavCmdInfo);

        CmdInfo mediaVolumeUpCmdInfo = new CmdInfo();
        mediaVolumeUpCmdInfo.ButtonId = R.id.media_volume_up_button;
        mediaVolumeUpCmdInfo.ApiMethodName = "media_volume_up";
        mediaVolumeUpCmdInfo.DialogInfo = new CmdDialogInfo();
        mediaVolumeUpCmdInfo.DialogInfo.Title = "Are you sure you want to turn volume up?";
        mediaVolumeUpCmdInfo.DialogInfo.Message = dialogMessage;
        mediaVolumeUpCmdInfo.DialogInfo.SuccessMessage = "Volume up!";
        mediaVolumeUpCmdInfo.DialogInfo.FailureMessage = "Could not turn volume up!";
        mediaVolumeUpCmdInfo.DialogInfo.ErrorMessage = "Error making request to turn volume up";
        mediaVolumeUpCmdInfo.DialogInfo.CancelMessage = "Ok, won't turn volume up";
        setupCommandButton(inflater, root, mediaVolumeUpCmdInfo);

        CmdInfo mediaVolumeDownCmdInfo = new CmdInfo();
        mediaVolumeDownCmdInfo.ButtonId = R.id.media_volume_down_button;
        mediaVolumeDownCmdInfo.ApiMethodName = "media_volume_down";
        mediaVolumeDownCmdInfo.DialogInfo = new CmdDialogInfo();
        mediaVolumeDownCmdInfo.DialogInfo.Title = "Are you sure you want to turn volume down?";
        mediaVolumeDownCmdInfo.DialogInfo.Message = dialogMessage;
        mediaVolumeDownCmdInfo.DialogInfo.SuccessMessage = "Volume down!";
        mediaVolumeDownCmdInfo.DialogInfo.FailureMessage = "Could not turn volume down!";
        mediaVolumeDownCmdInfo.DialogInfo.ErrorMessage = "Error making request to turn volume down";
        mediaVolumeDownCmdInfo.DialogInfo.CancelMessage = "Ok, won't turn volume down";
        setupCommandButton(inflater, root, mediaVolumeDownCmdInfo);

        CmdInfo scheduleSoftwareUpdateCmdInfo = new CmdInfo();
        scheduleSoftwareUpdateCmdInfo.ButtonId = R.id.schedule_software_update_button;
        scheduleSoftwareUpdateCmdInfo.ApiMethodName = "schedule_software_update";
        scheduleSoftwareUpdateCmdInfo.DialogInfo = new CmdDialogInfo();
        scheduleSoftwareUpdateCmdInfo.DialogInfo.Title = "Are you sure you want to schedule software update?";
        scheduleSoftwareUpdateCmdInfo.DialogInfo.Message = dialogMessage;
        scheduleSoftwareUpdateCmdInfo.DialogInfo.SuccessMessage = "Software Update scheduled!";
        scheduleSoftwareUpdateCmdInfo.DialogInfo.FailureMessage = "Could not schedule software update!";
        scheduleSoftwareUpdateCmdInfo.DialogInfo.ErrorMessage = "Error making request to schedule software update";
        scheduleSoftwareUpdateCmdInfo.DialogInfo.CancelMessage = "Ok, Software update will not be scheduled";

        scheduleSoftwareUpdateCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        scheduleSoftwareUpdateCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_schedule_software_update;
        scheduleSoftwareUpdateCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.schedule_software_update_offset_sec_edit_text;
        param.Name = "offset_sec";
        scheduleSoftwareUpdateCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, scheduleSoftwareUpdateCmdInfo);

        CmdInfo cancelSoftwareUpdateCmdInfo = new CmdInfo();
        cancelSoftwareUpdateCmdInfo.ButtonId = R.id.cancel_software_update_button;
        cancelSoftwareUpdateCmdInfo.ApiMethodName = "cancel_software_update";
        cancelSoftwareUpdateCmdInfo.DialogInfo = new CmdDialogInfo();
        cancelSoftwareUpdateCmdInfo.DialogInfo.Title = "Are you sure you want to cancel software update?";
        cancelSoftwareUpdateCmdInfo.DialogInfo.Message = dialogMessage;
        cancelSoftwareUpdateCmdInfo.DialogInfo.SuccessMessage = "software update cancelled!";
        cancelSoftwareUpdateCmdInfo.DialogInfo.FailureMessage = "Could not cancel software update!";
        cancelSoftwareUpdateCmdInfo.DialogInfo.ErrorMessage = "Error making request to cancel software update";
        cancelSoftwareUpdateCmdInfo.DialogInfo.CancelMessage = "Ok, won't cancel software update";
        setupCommandButton(inflater, root, cancelSoftwareUpdateCmdInfo);

        CmdInfo shareCmdInfo = new CmdInfo();
        shareCmdInfo.ButtonId = R.id.share_button;
        shareCmdInfo.ApiMethodName = "share";
        shareCmdInfo.DialogInfo = new CmdDialogInfo();
        shareCmdInfo.DialogInfo.Title = "Are you sure you want to share location or video?";
        shareCmdInfo.DialogInfo.Message = dialogMessage;
        shareCmdInfo.DialogInfo.SuccessMessage = "Location or video shared!";
        shareCmdInfo.DialogInfo.FailureMessage = "Could not share location or video!";
        shareCmdInfo.DialogInfo.ErrorMessage = "Error making request to share location or video";
        shareCmdInfo.DialogInfo.CancelMessage = "Ok, location or video won't be shared";

        shareCmdInfo.DialogInfo.ParamsInfo = new CmdDialogParamsInfo();
        shareCmdInfo.DialogInfo.ParamsInfo.ParamLayoutId = R.layout.dialog_cmd_share;
        shareCmdInfo.DialogInfo.ParamsInfo.Parameters = new ArrayList<CmdDialogParamInfo>();
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.share_type_edit_text;
        param.Name = "type";
        shareCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.share_locale_edit_text;
        param.Name = "locale";
        shareCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.share_timestamp_ms_edit_text;
        param.Name = "timestamp_ms";
        shareCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        param = new CmdDialogParamInfo();
        param.EditTextId = R.id.share_intent_edit_text;
        param.Name = "android.intent.extra.TEXT";
        shareCmdInfo.DialogInfo.ParamsInfo.Parameters.add(param);
        setupCommandButton(inflater, root, shareCmdInfo);

        CmdInfo upcomingCalendarEntriesCmdInfo = new CmdInfo();
        upcomingCalendarEntriesCmdInfo.ButtonId = R.id.upcoming_calendar_entries_button;
        upcomingCalendarEntriesCmdInfo.ApiMethodName = "upcoming_calendar_entries";
        upcomingCalendarEntriesCmdInfo.DialogInfo = new CmdDialogInfo();
        upcomingCalendarEntriesCmdInfo.DialogInfo.Title = "Are you sure you want to send calendar sync request?";
        upcomingCalendarEntriesCmdInfo.DialogInfo.Message = dialogMessage;
        upcomingCalendarEntriesCmdInfo.DialogInfo.SuccessMessage = "Calendar sync request sent!";
        upcomingCalendarEntriesCmdInfo.DialogInfo.FailureMessage = "Could not send calendar sync request!";
        upcomingCalendarEntriesCmdInfo.DialogInfo.ErrorMessage = "Error making request to send calendar sync request";
        upcomingCalendarEntriesCmdInfo.DialogInfo.CancelMessage = "Ok, won't send calendar sync request";
        setupCommandButton(inflater, root, upcomingCalendarEntriesCmdInfo);

        CmdInfo wakeUpCmdInfo = new CmdInfo();
        wakeUpCmdInfo.ButtonId = R.id.wake_up_button;
        wakeUpCmdInfo.ApiMethodName = "wake_up";
        wakeUpCmdInfo.DialogInfo = new CmdDialogInfo();
        wakeUpCmdInfo.DialogInfo.Title = "Are you sure you want to wake the car?";
        wakeUpCmdInfo.DialogInfo.Message = dialogMessage;
        wakeUpCmdInfo.DialogInfo.SuccessMessage = "Wake up request sent!";
        wakeUpCmdInfo.DialogInfo.FailureMessage = "Could not wake the car!";
        wakeUpCmdInfo.DialogInfo.ErrorMessage = "Error making wake up request";
        wakeUpCmdInfo.DialogInfo.CancelMessage = "Ok, won't request wake up";
        setupCommandButton(inflater, root, wakeUpCmdInfo);

        return root;
    }

    class CmdInfo {
        public String ApiMethodName;
        public @IdRes int ButtonId;
        public CmdDialogInfo DialogInfo;
    }

    class CmdDialogInfo {
        public String Title;
        public String Message;
        public String SuccessMessage;
        public String FailureMessage;
        public String ErrorMessage;
        public String CancelMessage;
        public CmdDialogParamsInfo ParamsInfo;
    }

    class CmdDialogParamsInfo {
        public @LayoutRes int ParamLayoutId;
        public ArrayList<CmdDialogParamInfo> Parameters;
    }

    class CmdDialogParamInfo {
        public String Name;
        public @IdRes int EditTextId;
    }

    private void setupCommandButton(
            final LayoutInflater inflater,
            final View root,
            final CmdInfo cmdInfo) {
        final Button button = (Button) root.findViewById(cmdInfo.ButtonId);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View paramView = null;
                if(cmdInfo.DialogInfo.ParamsInfo != null && cmdInfo.DialogInfo.ParamsInfo.Parameters != null ) {
                    paramView = inflater.inflate(cmdInfo.DialogInfo.ParamsInfo.ParamLayoutId, null);
                }

                final View finalParamView = paramView;
                AlertDialog alertDialog = new AlertDialog.Builder(root.getContext())
                        // set icon
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        // set view
                        .setView(paramView)
                        // set title
                        .setTitle(cmdInfo.DialogInfo.Title)
                        // set message
                        .setMessage(cmdInfo.DialogInfo.Message)
                        // set positive button
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                JSONObject jo = null;
                                if(cmdInfo.DialogInfo.ParamsInfo != null && cmdInfo.DialogInfo.ParamsInfo.Parameters != null ) {

                                    jo = new JSONObject();

                                    try {
                                        for (CmdDialogParamInfo paramInfo: cmdInfo.DialogInfo.ParamsInfo.Parameters) {
                                            final EditText editText = finalParamView.findViewById(paramInfo.EditTextId);
                                            String editTextValue = editText.getText().toString();

                                            // exception for how android.intent.extra.TEXT gets passed
                                            if(paramInfo.Name.equals("android.intent.extra.TEXT")) {
                                                JSONObject j = new JSONObject();
                                                j.put(paramInfo.Name, editTextValue);
                                                jo.put("value", j);
                                            } else {
                                                jo.put(paramInfo.Name, editTextValue);
                                            }
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                TeslaAPIWrapper.getInstance().executeCommandAsync(
                                        cmdInfo.ApiMethodName,
                                        jo,
                                        new TeslaAPIWrapper.CommandInterface() {
                                    @Override
                                    public void onCompletion(Result<CmdResponse> result) {
                                        if (result instanceof Result.Success) {
                                            final CmdResponse data = ((Result.Success<CmdResponse>) result).getData();

                                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    if(data.isResult()) {
                                                        Toast.makeText(CtrlApp.getAppContext(), cmdInfo.DialogInfo.SuccessMessage, Toast.LENGTH_LONG).show();
                                                    } else {
                                                        Toast.makeText(CtrlApp.getAppContext(),cmdInfo.DialogInfo.FailureMessage + " Reason: " + data.getReason(), Toast.LENGTH_LONG).show();
                                                    }
                                                }
                                            });
                                        } else {
                                            final Result.Error error = (Result.Error) result;
                                            System.out.println(error.toString());

                                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(CtrlApp.getAppContext(), cmdInfo.DialogInfo.ErrorMessage, Toast.LENGTH_LONG).show();
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        })
                        // set negative button
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(CtrlApp.getAppContext(), cmdInfo.DialogInfo.CancelMessage, Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });
    }
}