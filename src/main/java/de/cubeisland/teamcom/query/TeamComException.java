package de.cubeisland.teamcom.query;

public class TeamComException extends Exception
{
    public TeamComException()
    {
    }

    public TeamComException(String message)
    {
        super(message);
    }

    public TeamComException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public TeamComException(Throwable cause)
    {
        super(cause);
    }
}
