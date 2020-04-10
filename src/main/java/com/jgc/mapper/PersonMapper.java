package com.jgc.mapper;

import com.jgc.bean.Person;

public interface PersonMapper {

    public Person getPersonByID(Integer id);

    public boolean savePerson(Person person);
}
