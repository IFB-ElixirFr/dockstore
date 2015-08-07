/*
 * Copyright (C) 2015 Consonance
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.consonance.guqin.jdbi;

import io.consonance.guqin.core.Token;
import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author dyuen
 */
public class TokenDAO extends AbstractDAO<Token> {
    public TokenDAO(SessionFactory factory) {
        super(factory);
    }

    public Token findById(Long id) {
        return get(id);
    }

    public long create(Token token) {
        return persist(token).getId();
    }

    public List<Token> findAll() {
        return list(namedQuery("io.consonance.guqin.core.Token.findAll"));
    }
}