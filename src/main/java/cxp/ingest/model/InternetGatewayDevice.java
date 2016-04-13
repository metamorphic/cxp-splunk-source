package cxp.ingest.model;

import java.util.Date;

/**
 * Created by markmo on 4/04/2016.
 */
public class InternetGatewayDevice {

    private Date eventTime;
    private String manufacturer;
    private String manufacturerOUI;
    private String productClass;
    private String serialNumber;
    private String hardwareVersion;
    private String softwareVersion;
    private String modemFirmwareVersion;
    private String managementServerURL;
    private String managementServerUsername; // email address
    private int upTime;
    private int lanDeviceTotalAssociations;
    private int lanDeviceTotalPskFailures;
    private boolean lanDeviceAutoChannelEnable;
    private int lanDeviceErrorsReceived;
    private int lanDeviceErrorsSent;
    private boolean lanDeviceCrcError;
    private int lanDeviceNumberFailedFrames;
    private int lanDevicePacketsErrored;
    private int lanDevicePacketsDropped;
    private int lanDeviceTotalBytesReceived;
    private int lanDeviceTotalBytesSent;
    private int lanDeviceTotalPacketsReceived;
    private int lanDeviceTotalPacketsSent;
    private int wanDeviceTotalBytesReceived;
    private int wanDeviceTotalBytesSent;
    private int wanDeviceTotalPacketsReceived;
    private int wanDeviceTotalPacketsSent;
    private String lanDeviceStandard;
    private String lanDeviceBasicEncryptionModes;
    private String lanDeviceWpaEncryptionModes;
    private int totalMemory;
    private int freeMemory;
    private double cpuUsage;
    private int processNumberEntries;
    private String wanDeviceUpstreamAttenuation;
    private String wanDeviceDownstreamAttenuation;
    private boolean lanDeviceHostActive;
    private String lanDeviceAssociatedDeviceMacAddress;
    private String lanDeviceAssociatedDeviceIpAddress;
    private String lanDeviceAssociatedDeviceAuthenticationState;
    private String lanDeviceAssociatedDeviceType;
    private String sessionId;

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturerOUI() {
        return manufacturerOUI;
    }

    public void setManufacturerOUI(String manufacturerOUI) {
        this.manufacturerOUI = manufacturerOUI;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getModemFirmwareVersion() {
        return modemFirmwareVersion;
    }

    public void setModemFirmwareVersion(String modemFirmwareVersion) {
        this.modemFirmwareVersion = modemFirmwareVersion;
    }

    public String getManagementServerURL() {
        return managementServerURL;
    }

    public void setManagementServerURL(String managementServerURL) {
        this.managementServerURL = managementServerURL;
    }

    public String getManagementServerUsername() {
        return managementServerUsername;
    }

    public void setManagementServerUsername(String managementServerUsername) {
        this.managementServerUsername = managementServerUsername;
    }

    public int getUpTime() {
        return upTime;
    }

    public void setUpTime(int upTime) {
        this.upTime = upTime;
    }

    public int getLanDeviceTotalAssociations() {
        return lanDeviceTotalAssociations;
    }

    public void setLanDeviceTotalAssociations(int lanDeviceTotalAssociations) {
        this.lanDeviceTotalAssociations = lanDeviceTotalAssociations;
    }

    public int getLanDeviceTotalPskFailures() {
        return lanDeviceTotalPskFailures;
    }

    public void setLanDeviceTotalPskFailures(int lanDeviceTotalPskFailures) {
        this.lanDeviceTotalPskFailures = lanDeviceTotalPskFailures;
    }

    public boolean isLanDeviceAutoChannelEnable() {
        return lanDeviceAutoChannelEnable;
    }

    public void setLanDeviceAutoChannelEnable(boolean lanDeviceAutoChannelEnable) {
        this.lanDeviceAutoChannelEnable = lanDeviceAutoChannelEnable;
    }

    public int getLanDeviceErrorsReceived() {
        return lanDeviceErrorsReceived;
    }

    public void setLanDeviceErrorsReceived(int lanDeviceErrorsReceived) {
        this.lanDeviceErrorsReceived = lanDeviceErrorsReceived;
    }

    public int getLanDeviceErrorsSent() {
        return lanDeviceErrorsSent;
    }

    public void setLanDeviceErrorsSent(int lanDeviceErrorsSent) {
        this.lanDeviceErrorsSent = lanDeviceErrorsSent;
    }

    public boolean isLanDeviceCrcError() {
        return lanDeviceCrcError;
    }

    public void setLanDeviceCrcError(boolean lanDeviceCrcError) {
        this.lanDeviceCrcError = lanDeviceCrcError;
    }

    public int getLanDeviceNumberFailedFrames() {
        return lanDeviceNumberFailedFrames;
    }

    public void setLanDeviceNumberFailedFrames(int lanDeviceNumberFailedFrames) {
        this.lanDeviceNumberFailedFrames = lanDeviceNumberFailedFrames;
    }

    public int getLanDevicePacketsErrored() {
        return lanDevicePacketsErrored;
    }

    public void setLanDevicePacketsErrored(int lanDevicePacketsErrored) {
        this.lanDevicePacketsErrored = lanDevicePacketsErrored;
    }

    public int getLanDevicePacketsDropped() {
        return lanDevicePacketsDropped;
    }

    public void setLanDevicePacketsDropped(int lanDevicePacketsDropped) {
        this.lanDevicePacketsDropped = lanDevicePacketsDropped;
    }

    public int getLanDeviceTotalBytesReceived() {
        return lanDeviceTotalBytesReceived;
    }

    public void setLanDeviceTotalBytesReceived(int lanDeviceTotalBytesReceived) {
        this.lanDeviceTotalBytesReceived = lanDeviceTotalBytesReceived;
    }

    public int getLanDeviceTotalBytesSent() {
        return lanDeviceTotalBytesSent;
    }

    public void setLanDeviceTotalBytesSent(int lanDeviceTotalBytesSent) {
        this.lanDeviceTotalBytesSent = lanDeviceTotalBytesSent;
    }

    public int getLanDeviceTotalPacketsReceived() {
        return lanDeviceTotalPacketsReceived;
    }

    public void setLanDeviceTotalPacketsReceived(int lanDeviceTotalPacketsReceived) {
        this.lanDeviceTotalPacketsReceived = lanDeviceTotalPacketsReceived;
    }

    public int getLanDeviceTotalPacketsSent() {
        return lanDeviceTotalPacketsSent;
    }

    public void setLanDeviceTotalPacketsSent(int lanDeviceTotalPacketsSent) {
        this.lanDeviceTotalPacketsSent = lanDeviceTotalPacketsSent;
    }

    public int getWanDeviceTotalBytesReceived() {
        return wanDeviceTotalBytesReceived;
    }

    public void setWanDeviceTotalBytesReceived(int wanDeviceTotalBytesReceived) {
        this.wanDeviceTotalBytesReceived = wanDeviceTotalBytesReceived;
    }

    public int getWanDeviceTotalBytesSent() {
        return wanDeviceTotalBytesSent;
    }

    public void setWanDeviceTotalBytesSent(int wanDeviceTotalBytesSent) {
        this.wanDeviceTotalBytesSent = wanDeviceTotalBytesSent;
    }

    public int getWanDeviceTotalPacketsReceived() {
        return wanDeviceTotalPacketsReceived;
    }

    public void setWanDeviceTotalPacketsReceived(int wanDeviceTotalPacketsReceived) {
        this.wanDeviceTotalPacketsReceived = wanDeviceTotalPacketsReceived;
    }

    public int getWanDeviceTotalPacketsSent() {
        return wanDeviceTotalPacketsSent;
    }

    public void setWanDeviceTotalPacketsSent(int wanDeviceTotalPacketsSent) {
        this.wanDeviceTotalPacketsSent = wanDeviceTotalPacketsSent;
    }

    public String getLanDeviceStandard() {
        return lanDeviceStandard;
    }

    public void setLanDeviceStandard(String lanDeviceStandard) {
        this.lanDeviceStandard = lanDeviceStandard;
    }

    public String getLanDeviceBasicEncryptionModes() {
        return lanDeviceBasicEncryptionModes;
    }

    public void setLanDeviceBasicEncryptionModes(String lanDeviceBasicEncryptionModes) {
        this.lanDeviceBasicEncryptionModes = lanDeviceBasicEncryptionModes;
    }

    public String getLanDeviceWpaEncryptionModes() {
        return lanDeviceWpaEncryptionModes;
    }

    public void setLanDeviceWpaEncryptionModes(String lanDeviceWpaEncryptionModes) {
        this.lanDeviceWpaEncryptionModes = lanDeviceWpaEncryptionModes;
    }

    public int getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(int totalMemory) {
        this.totalMemory = totalMemory;
    }

    public int getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(int freeMemory) {
        this.freeMemory = freeMemory;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public int getProcessNumberEntries() {
        return processNumberEntries;
    }

    public void setProcessNumberEntries(int processNumberEntries) {
        this.processNumberEntries = processNumberEntries;
    }

    public String getWanDeviceUpstreamAttenuation() {
        return wanDeviceUpstreamAttenuation;
    }

    public void setWanDeviceUpstreamAttenuation(String wanDeviceUpstreamAttenuation) {
        this.wanDeviceUpstreamAttenuation = wanDeviceUpstreamAttenuation;
    }

    public String getWanDeviceDownstreamAttenuation() {
        return wanDeviceDownstreamAttenuation;
    }

    public void setWanDeviceDownstreamAttenuation(String wanDeviceDownstreamAttenuation) {
        this.wanDeviceDownstreamAttenuation = wanDeviceDownstreamAttenuation;
    }

    public boolean isLanDeviceHostActive() {
        return lanDeviceHostActive;
    }

    public void setLanDeviceHostActive(boolean lanDeviceHostActive) {
        this.lanDeviceHostActive = lanDeviceHostActive;
    }

    public String getLanDeviceAssociatedDeviceMacAddress() {
        return lanDeviceAssociatedDeviceMacAddress;
    }

    public void setLanDeviceAssociatedDeviceMacAddress(String lanDeviceAssociatedDeviceMacAddress) {
        this.lanDeviceAssociatedDeviceMacAddress = lanDeviceAssociatedDeviceMacAddress;
    }

    public String getLanDeviceAssociatedDeviceIpAddress() {
        return lanDeviceAssociatedDeviceIpAddress;
    }

    public void setLanDeviceAssociatedDeviceIpAddress(String lanDeviceAssociatedDeviceIpAddress) {
        this.lanDeviceAssociatedDeviceIpAddress = lanDeviceAssociatedDeviceIpAddress;
    }

    public String getLanDeviceAssociatedDeviceAuthenticationState() {
        return lanDeviceAssociatedDeviceAuthenticationState;
    }

    public void setLanDeviceAssociatedDeviceAuthenticationState(String lanDeviceAssociatedDeviceAuthenticationState) {
        this.lanDeviceAssociatedDeviceAuthenticationState = lanDeviceAssociatedDeviceAuthenticationState;
    }

    public String getLanDeviceAssociatedDeviceType() {
        return lanDeviceAssociatedDeviceType;
    }

    public void setLanDeviceAssociatedDeviceType(String lanDeviceAssociatedDeviceType) {
        this.lanDeviceAssociatedDeviceType = lanDeviceAssociatedDeviceType;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
