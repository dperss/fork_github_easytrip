package com.easytrip.easytrip.service.impl;

import com.easytrip.easytrip.domain.Person;
import com.easytrip.easytrip.repository.PersonRepository;
import com.easytrip.easytrip.service.IService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements IService<Person> {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Page<Person> findAll(Pageable pageable, String searchText) {
        return personRepository.findAllPersons(pageable, searchText);
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    @Override
    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public Person saveOrUpdate(Person person) {
        return personRepository.save(person);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            personRepository.deleteById(id);
            jsonObject.put("message", "Person deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

}