package mate.academy.bookstore.repository.book;

import static mate.academy.bookstore.repository.book.spec.AuthorSpecificationProvider.COLUMN_AUTHOR;
import static mate.academy.bookstore.repository.book.spec.TitleSpecificationProvider.COLUMN_TITLE;

import lombok.RequiredArgsConstructor;
import mate.academy.bookstore.dto.book.BookSearchParameters;
import mate.academy.bookstore.model.Book;
import mate.academy.bookstore.repository.SpecificationBuilder;
import mate.academy.bookstore.repository.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> bookSpecificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters searchParameters) {
        Specification<Book> spec = Specification.where(null);
        if (searchParameters.authors() != null && searchParameters.authors().length > 0) {
            spec = spec.and(bookSpecificationProviderManager
                    .getSpecificationProvider(COLUMN_AUTHOR)
                    .getSpecification(searchParameters.authors()));
        }
        if (searchParameters.titles() != null && searchParameters.titles().length > 0) {
            spec = spec.and(bookSpecificationProviderManager
                    .getSpecificationProvider(COLUMN_TITLE)
                    .getSpecification(searchParameters.titles()));
        }
        return spec;
    }
}
