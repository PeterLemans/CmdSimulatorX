package com.nachattar.simulator.commandexecution;

public class CommandOutputBO {

	private String output;
	private Integer systemRC;
	private String result;
	private String error;
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public Integer getSystemRC() {
		return systemRC;
	}
	public void setSystemRC(Integer systemRC) {
		this.systemRC = systemRC;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public CommandOutputBO(String output, Integer systemRC, String result, String error) {
		super();
		this.output = output;
		this.systemRC = systemRC;
		this.result = result;
		this.error = error;
	}
	@Override
	public String toString() {
		return "CommandOutputBO [output=" + output + ", systemRC=" + systemRC + ", result=" + result + ", error="
				+ error + "]";
	}
	
}
