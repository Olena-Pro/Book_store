package mate.academy.bookstore.mapper.impl;

import javax.annotation.processing.Generated;
import mate.academy.bookstore.dto.category.CategoryDto;
import mate.academy.bookstore.dto.category.CategoryRequestDto;
import mate.academy.bookstore.mapper.CategoryMapper;
import mate.academy.bookstore.model.Category;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:16:00+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toDto(Category category) {
        if ( category == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String description = null;

        if ( category.getId() != null ) {
            id = category.getId();
        }
        if ( category.getName() != null ) {
            name = category.getName();
        }
        if ( category.getDescription() != null ) {
            description = category.getDescription();
        }

        CategoryDto categoryDto = new CategoryDto( id, name, description );

        return categoryDto;
    }

    @Override
    public Category toModel(CategoryRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Category category = new Category();

        if ( requestDto.name() != null ) {
            category.setName( requestDto.name() );
        }
        if ( requestDto.description() != null ) {
            category.setDescription( requestDto.description() );
        }

        return category;
    }
}
