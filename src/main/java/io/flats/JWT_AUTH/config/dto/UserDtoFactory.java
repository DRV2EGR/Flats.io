package io.flats.JWT_AUTH.config.dto;


import io.flats.entity.User;

public class UserDtoFactory {
    public static UserDto createUserDto(User user) {
//        if (user instanceof Initiator)
//            return new InitiatorDto((Initiator) user);
//        if (user instanceof Investor)
//            return new InvestorDto((Investor) user);
//        if (user instanceof Curator)
//            return new CuratorDto((Curator) user);
        return new UserDto(user);
    }
}
