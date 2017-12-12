package series.mum.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import series.mum.domain.*;

/**
 * Created by Grimg on 12/12/2017.
 */
public interface SeriesDAO extends JpaRepository<Series, Integer> {

    Page<Series> findAll(Pageable pageable);
    Series save(Series series);
}
