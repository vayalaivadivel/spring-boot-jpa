package org.sample.sping.boot.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.sample.sping.boot.jpa.dao.EmpDao;
import org.sample.sping.boot.jpa.entity.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author vadivel
 *
 */
@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	private EmpDao empDao;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Emp> getAllEmployee() {
		return empDao.findAll();
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST)
	public String save(@RequestBody final Emp emp) {
		LOG.info("---save---");
		LOG.info("Content of emp: {}", emp);
		final Emp e = empDao.save(emp);
		return String.format("Records saved successfully with the id %s", e.getId());

	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.DELETE)
	public String delete(@RequestParam("id") final Optional<Integer> id) {
		empDao.deleteById(id.get());
		return "Record deleted successfully";
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.PUT)
	public String update(@RequestBody final Emp emp) {
		empDao.save(emp);
		return "Record updated successfully";
	}
}
