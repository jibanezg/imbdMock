package series.mum.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import series.mum.domain.Series;

import java.util.List;

/**
 * Created by Grimg on 12/11/2017.
 */
public interface SeriesService {

    Page<Series> showTVSeries();
    Series save(Series series);
}
