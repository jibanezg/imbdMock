package series.mum.controller;

import actor.mum.domain.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import series.mum.service.SeriesService;
import series.mum.domain.Series;

/**
 * Created by Grimg on 12/11/2017.
 */
@Controller
public class SeriesController {

    @Autowired
    private SeriesService seriesService;

    @RequestMapping(value = "/")
    public ModelAndView showTVSeries(){

        Page<Series> result = seriesService.showTVSeries();

        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        return mav;
    }

    @RequestMapping(value = "/series")
    public void createSeries(){

        Series series = new Series();
        Actor actor = new Actor();
        actor.setBiography("Bla bla");
        actor.setName("I am blah");
        actor.setPlaceOfBirth("some location");
        series.addActor(actor);

        seriesService.save(series);

    }


}
