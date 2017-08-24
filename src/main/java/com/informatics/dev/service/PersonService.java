package com.informatics.dev.service;

import java.util.List;

import com.informatics.dev.model.Person;
import com.informatics.dev.model.PersonRecord;

public interface PersonService {
	void startTask(Person person);
	List<PersonRecord> getPendingTasks();
	void reviewPersonTask(String taskId);
}
