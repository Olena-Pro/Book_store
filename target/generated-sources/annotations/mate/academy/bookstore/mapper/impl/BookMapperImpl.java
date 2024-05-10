package mate.academy.bookstore.mapper.impl;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import mate.academy.bookstore.dto.book.BookDto;
import mate.academy.bookstore.dto.book.BookWithoutCategoryDto;
import mate.academy.bookstore.dto.book.CreateBookRequestDto;
import mate.academy.bookstore.mapper.BookMapper;
import mate.academy.bookstore.model.Book;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T13:16:00+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        if ( book.getId() != null ) {
            bookDto.setId( book.getId() );
        }
        if ( book.getTitle() != null ) {
            bookDto.setTitle( book.getTitle() );
        }
        if ( book.getAuthor() != null ) {
            bookDto.setAuthor( book.getAuthor() );
        }
        if ( book.getIsbn() != null ) {
            bookDto.setIsbn( book.getIsbn() );
        }
        if ( book.getPrice() != null ) {
            bookDto.setPrice( book.getPrice() );
        }
        if ( book.getDescription() != null ) {
            bookDto.setDescription( book.getDescription() );
        }
        if ( book.getCoverImage() != null ) {
            bookDto.setCoverImage( book.getCoverImage() );
        }

        setCategoryIds( bookDto, book );

        return bookDto;
    }

    @Override
    public BookWithoutCategoryDto toBookWithoutCategoryDto(Book book) {
        if ( book == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String author = null;
        String isbn = null;
        BigDecimal price = null;
        String description = null;
        String coverImage = null;

        if ( book.getId() != null ) {
            id = book.getId();
        }
        if ( book.getTitle() != null ) {
            title = book.getTitle();
        }
        if ( book.getAuthor() != null ) {
            author = book.getAuthor();
        }
        if ( book.getIsbn() != null ) {
            isbn = book.getIsbn();
        }
        if ( book.getPrice() != null ) {
            price = book.getPrice();
        }
        if ( book.getDescription() != null ) {
            description = book.getDescription();
        }
        if ( book.getCoverImage() != null ) {
            coverImage = book.getCoverImage();
        }

        BookWithoutCategoryDto bookWithoutCategoryDto = new BookWithoutCategoryDto( id, title, author, isbn, price, description, coverImage );

        return bookWithoutCategoryDto;
    }

    @Override
    public Book toModel(CreateBookRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Book book = new Book();

        if ( requestDto.getTitle() != null ) {
            book.setTitle( requestDto.getTitle() );
        }
        if ( requestDto.getAuthor() != null ) {
            book.setAuthor( requestDto.getAuthor() );
        }
        if ( requestDto.getIsbn() != null ) {
            book.setIsbn( requestDto.getIsbn() );
        }
        if ( requestDto.getPrice() != null ) {
            book.setPrice( requestDto.getPrice() );
        }
        if ( requestDto.getDescription() != null ) {
            book.setDescription( requestDto.getDescription() );
        }
        if ( requestDto.getCoverImage() != null ) {
            book.setCoverImage( requestDto.getCoverImage() );
        }

        setCategories( book, requestDto );

        return book;
    }
}
