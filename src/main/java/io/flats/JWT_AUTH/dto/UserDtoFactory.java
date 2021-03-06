package io.flats.JWT_AUTH.dto;


import io.flats.entity.User;

/**
 * The type User dto factory.
 */
public class UserDtoFactory {
    /**
     * Create user dto user dto.
     *
     * @param user the user
     * @return the user dto
     */
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
