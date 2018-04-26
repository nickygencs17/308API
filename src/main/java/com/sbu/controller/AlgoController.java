package com.sbu.controller;

import com.sbu.data.entitys.Move;
import com.sbu.data.entitys.Update;
import com.sbu.data.entitys.UsState;
import com.sbu.services.AlgoService;
import com.sbu.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

import static com.sbu.utils.ResponseUtil.build200;

@RestController
@CrossOrigin
@Component
@RequestMapping("/algorithm")
public class AlgoController {

    @Autowired
    AlgoService algoService;

    @Autowired
    StateService stateService;
    ArrayList<Move> moves = new ArrayList<>();
    UsState selectedState;
    int pcoefficient;
    int ccoefficient;
    int fcoefficient;

    @RequestMapping(method = RequestMethod.GET)
    Response getStartAlgo(@RequestParam("state") String stateName, @RequestParam("pcoefficient") int pcoefficient,
                          @RequestParam("ccoefficient") int ccoefficient, @RequestParam("fcoefficient") int fcoefficient) {
        this.pcoefficient = pcoefficient;
        this.ccoefficient = ccoefficient;
        this.fcoefficient = fcoefficient;
        selectedState = stateService.getStatebyId(stateName);
        selectedState.setCongressionalDistricts(stateService.getCongressionalDistrictsbyState(selectedState.getState_id()));
        selectedState.setPrecincts(stateService.getPrecinctsbyState(selectedState.getState_id()));
        return getUpdate();
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    Response getUpdate() {
        algoService.startAlgorithm(selectedState, pcoefficient, ccoefficient, fcoefficient, moves);
        Update update = new Update(moves);
        moves.clear();
        return build200(update);
    }
}
