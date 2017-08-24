package com.informatics.dev.model;

public class PersonRecord {
	private Person person;
	private String taskId;
	private String processId;
	
	public PersonRecord(Person person, String taskId,String processId) {
		this.person = person;
		this.taskId = taskId;
		this.processId = processId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	
	

}
