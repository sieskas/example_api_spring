package com.example.springboot.api.v1.mappers;

import com.example.springboot.api.resources.ExampleRequestResource;
import com.example.springboot.api.resources.ItemResource;
import com.example.springboot.domain.model.Example;
import com.example.springboot.domain.model.Item;
import com.example.springboot.domain.model.TypeEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ExampleMapper {
	Example toModel(ExampleRequestResource exampleRequestResource);

	@Mapping(source = "type", target = "type", qualifiedByName = "convertItemType")
	Item toModel(ItemResource itemResource);

	@Named("convertItemType")
	default TypeEnum convertItemType(String type) {
		return TypeEnum.valueOf(type);
	}
}
