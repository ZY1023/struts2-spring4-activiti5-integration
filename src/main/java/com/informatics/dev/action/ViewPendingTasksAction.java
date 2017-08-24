package com.informatics.dev.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.informatics.dev.model.PersonRecord;
import com.informatics.dev.service.PersonService;
import com.opensymphony.xwork2.ActionSupport;

public class ViewPendingTasksAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	List<PersonRecord> tasksList;
	PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	

	public List<PersonRecord> getTasksList() {
		return tasksList;
	}

	public void setTasksList(List<PersonRecord> tasksList) {
		this.tasksList = tasksList;
	}

	public String showTasks() {
		tasksList = personService.getPendingTasks();
		return "showTasks";
	}
	public String completeTask(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String taskId = request.getParameter("taskId");
		personService.reviewPersonTask(taskId);
		tasksList = personService.getPendingTasks();
		return "showTasks";
	}

}
