package series.mum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import series.mum.dao.SeriesDAO;
import series.mum.domain.Series;

import java.util.List;

/**
 * Created by Grimg on 12/12/2017.
 */
@Service
public class SeriesServiceImpl implements SeriesService {

    @Autowired
    private SeriesDAO seriesDAO;

    @Override
    public Page<Series> showTVSeries() {
        PageRequest pageRequest = new PageRequest(0,20);
        return seriesDAO.findAll(pageRequest);
    }

    @Override
    public Series save(Series series) {
        return seriesDAO.save(series);
    }
}
