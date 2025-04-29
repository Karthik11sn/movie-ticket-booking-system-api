package com.example.movie.service.serviceImpl;

import com.example.movie.dto.TheaterRequest;
import com.example.movie.dto.TheaterResponse;
import com.example.movie.entity.Theater;
import com.example.movie.entity.TheaterOwner;
import com.example.movie.entity.UserDetails;
import com.example.movie.enums.UserRole;
import com.example.movie.exceptions.TheaterNotFoundByIdException;
import com.example.movie.exceptions.UserNotFoundByEmailException;
import com.example.movie.mapper.TheaterMapper;
import com.example.movie.repository.TheaterRepository;
import com.example.movie.repository.UserRepository;
import com.example.movie.service.TheaterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {
    private final TheaterRepository theaterRepository;
    private final TheaterMapper theaterMapper;
    private final UserRepository userRepository;

    @Override
    public TheaterResponse addTheater(String email, TheaterRequest theaterRequest) {
        if(userRepository.existsByEmail(email) && userRepository.findByEmail(email).getUserRole() == UserRole.THEATER_OWNER ){
            UserDetails user = userRepository.findByEmail(email);
            Theater theater = copy(theaterRequest, new Theater(), user);
            return theaterMapper.theaterResponseMapper(theater);
        }
        throw new UserNotFoundByEmailException("No Theater Owner with the provided email is present");
    }

    @Override
    public TheaterResponse findTheater(String theaterId) {
        if(theaterRepository.existsById(theaterId)){
            Theater theater = theaterRepository.findById(theaterId).get();
            return theaterMapper.theaterResponseMapper(theater);
        }
        throw new TheaterNotFoundByIdException("Theater not found by the id");
    }

    @Override
    public TheaterResponse updateTheater(String theaterId, TheaterRequest registerationRequest) {
        if(theaterRepository.existsById(theaterId)) {
            Theater theater = theaterRepository.findById(theaterId).get();
            theater = copy(registerationRequest, theater);
            return theaterMapper.theaterResponseMapper(theater);
        }
        throw new TheaterNotFoundByIdException("Theater not found by id");
    }

    private Theater copy(TheaterRequest registerationRequest, Theater theater , UserDetails userDetails){
        theater.setAddress(registerationRequest.address());
        theater.setCity(registerationRequest.city());
        theater.setName(registerationRequest.name());
        theater.setLandmark(registerationRequest.landmark());
        theater.setTheaterOwner((TheaterOwner) userDetails);
        theaterRepository.save(theater);
        return theater;
    }
    private Theater copy(TheaterRequest registerationRequest, Theater theater) {
        theater.setAddress(registerationRequest.address());
        theater.setCity(registerationRequest.city());
        theater.setName(registerationRequest.name());
        theater.setLandmark(registerationRequest.landmark());
        theaterRepository.save(theater);
        return theater;
    }


}
