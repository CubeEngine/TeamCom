package de.cubeisland.teamcom.query.command;

import de.cubeisland.teamcom.query.Command;

/**
 * Searches for custom client properties specified by ident and value. The value parameter can include regular characters and SQL wildcard characters (e.g. %).
 * <br><br>
 * Syntax:
 * <br>customsearch ident={ident} pattern={pattern}
 */
public class CustomSearch extends Command
{
    public CustomSearch ident(String ident, String pattern)
    {
        this.setParam("ident", ident);
        this.setParam("pattern", pattern);
        return this;
    }
}
