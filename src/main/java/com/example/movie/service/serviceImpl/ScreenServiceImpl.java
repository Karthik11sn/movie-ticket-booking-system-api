package com.example.movie.service.serviceImpl;

import com.example.movie.dto.ScreenRequest;
import com.example.movie.dto.ScreenResponse;
import com.example.movie.entity.Screen;
import com.example.movie.entity.Seat;
import com.example.movie.entity.Theater;
import com.example.movie.exceptions.NoOfRowsExceedCapacityException;
import com.example.movie.exceptions.ScreenNotFoundByIdException;
import com.example.movie.exceptions.TheaterNotFoundByIdException;
import com.example.movie.mapper.ScreenMapper;
import com.example.movie.repository.ScreenRepository;
import com.example.movie.repository.SeatRepository;
import com.example.movie.repository.TheaterRepository;
import com.example.movie.service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService {
    private final TheaterRepository theaterRepository;
    private final ScreenRepository screenRepository;
    private final SeatRepository seatRepository;
    private final ScreenMapper screenMapper;

    @Override
    public ScreenResponse addScreen(ScreenRequest screenRequest, String theaterId) {
        if (theaterRepository.existsById(theaterId)) {
            Theater theater = theaterRepository.findById(theaterId).get();
            Screen screen = copy(screenRequest, new Screen(), theater);
            return screenMapper.screenResponseMapper(screen);
        }

        throw new TheaterNotFoundByIdException("No Theater found by ID");


    }

    @Override
    public ScreenResponse findScreen(String theaterId, String screenId) {
        if(theaterRepository.existsById(theaterId)){
            if(screenRepository.existsById(screenId)){
                return screenMapper.screenResponseMapper(screenRepository.findById(screenId).get());
            }
            throw new ScreenNotFoundByIdException("Screen Not Found by Id");
        }
        throw new TheaterNotFoundByIdException("Theater not found by Id");
    }

    private Screen copy(ScreenRequest screenRequest, Screen screen, Theater theater){
        screen.setScreenType(screenRequest.screenType());
        screen.setCapacity(screenRequest.capacity());
        if (screenRequest.noOfRows() > screenRequest.capacity())
            throw new NoOfRowsExceedCapacityException("The no.of rows exceed the capacity");
        screen.setNoOfRows(screenRequest.noOfRows());
        screen.setTheater(theater);
        screenRepository.save(screen);
        screen.setSeats(createSeats(screen, screenRequest.capacity()));
        return screen;
    }

    private List<Seat> createSeats (Screen screen, Integer capacity){
        List<Seat> seats = new LinkedList<>();
        int noOfSeatsPerRow = screen.getCapacity() / screen.getNoOfRows();
        char row = 'A';
        for (int i = 1, j = 1; i <= capacity; i++, j++) {
            Seat seat = new Seat();
            seat.setScreen(screen);
            seat.setName(row + "" + j);
            seatRepository.save(seat);
            seats.add(seat);
            if (j == noOfSeatsPerRow) {
                j = 0;
                row++;
            }
        }
        return seats;

    }




}
