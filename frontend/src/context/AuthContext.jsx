import React, { createContext, useContext, useEffect, useState } from 'react';
import { setAuthToken } from '../api';

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(true);
    const [token, setToken] = useState(null);

    useEffect(() => {
        setAuthToken(token);
    }, [token]);

    useEffect(() => {
        const storedUser = localStorage.getItem('User');
        const storedToken = localStorage.getItem("authToken");

        if (storedUser) setUser(JSON.parse(storedUser));
        if (storedToken) setToken(storedToken);

        setLoading(false);
    }, []);

    const login = (userDataFromBackEnd, jwtToken) => {
        setUser(userDataFromBackEnd);
        setToken(jwtToken);

        localStorage.setItem("User", JSON.stringify(userDataFromBackEnd));
        localStorage.setItem("authToken", jwtToken);
    };

    const logout = () => {
        setUser(null);
        setToken(null);

        localStorage.removeItem("User");
        localStorage.removeItem("authToken");
    };

    const value = {
        user,
        token,
        setUser,
        setToken,
        login,
        logout,
        loading,
        isAuthenticated: !!user
    };

    return (
        <AuthContext.Provider value={value}>
            {!loading && children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => {
    const context = useContext(AuthContext);
    if (context === undefined) {
        throw new Error('useAuth must be used within an AuthProvider');
    }
    return context;
};