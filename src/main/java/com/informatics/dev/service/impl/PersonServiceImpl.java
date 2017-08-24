package com.informatics.dev.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.impl.ProcessEngineImpl;
import org.activiti.engine.runtime.ProcessInstance;

import com.informatics.dev.dao.PersonDAO;
import com.informatics.dev.model.Person;
import com.informatics.dev.model.PersonRecord;
import com.informatics.dev.service.PersonService;

public class PersonServiceImpl implements PersonService, JavaDelegate {
	// private String fileName =
	// getClass().getClassLoader().getResourceAsStream("PersonProcess.bpmn").toString();

	ProcessEngineImpl processEngine;
	RepositoryService repositoryService;
	RuntimeService runtimeService;
	TaskService taskService;
	ManagementService managementService;
	PersonDAO personDAO;

	public ManagementService getManagementService() {
		return managementService;
	}

	public void setManagementService(ManagementService managementService) {
		this.managementService = managementService;
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	public RepositoryService getRepositoryService() {
		return repositoryService;
	}

	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}

	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public ProcessEngineImpl getProcessEngine() {
		return processEngine;
	}

	public void setProcessEngine(ProcessEngineImpl processEngine) {
		this.processEngine = processEngine;
	}

	@Override
	public void startTask(Person person) {
		try {
			String fileName = "D:\\Other\\DevelopmentTask\\Code\\DevTask\\src\\main\\resources\\diagrams\\PersonProcess.bpmn";
			if (processEngine != null) {
				repositoryService.createDeployment()
						.addInputStream("PersonProcess.bpmn20.xml", new FileInputStream(fileName)).deploy();
				Map<String, Object> variableMap = new HashMap<String, Object>();
				variableMap.put("userName", person.getUserName());
				variableMap.put("age", person.getAge());
				variableMap.put("email", person.getEmail());
				runtimeService.startProcessInstanceByKey("personProcess",
						person.getUserName(), variableMap);
				personDAO.addPerson(person);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("executing the process ..");

	}

	@Override
	public List<PersonRecord> getPendingTasks() {
		return personDAO.getPendingTasks();
	}

	@Override
	public void reviewPersonTask(String taskId) {
		taskService.complete(taskId);
	}

}
