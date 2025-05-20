import React, { createContext, useContext, useEffect, useState } from "react";
import { setAuthToken } from "../api";
import { jwtDecode } from "jwt-decode";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [token, setToken] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    setAuthToken(token);
  }, [token]);

  useEffect(() => {
    const initializeAuth = () => {
      try {
        const storedUser = localStorage.getItem("User");
        const storedToken = localStorage.getItem("authToken");

        if (storedUser) {
          const parsedUser = JSON.parse(storedUser);
          if (parsedUser && typeof parsedUser === "object") {
            setUser(parsedUser);
          } else {
            localStorage.removeItem("User");
          }
        }

        if (storedToken) {
          setToken(storedToken);
        }
      } catch (err) {
        console.error("Auth initialization error:", err);
        setError(err);
        localStorage.removeItem("User");
        localStorage.removeItem("authToken");
      } finally {
        setLoading(false);
      }
    };

    initializeAuth();
  }, []);

  const login = (jwtToken) => {
    try {
      if (!jwtToken) {
        throw new Error("Token inválido");
      }

      const decoded = jwtDecode(jwtToken);
      console.log("Token decodificado:", decoded);

      setUser(decoded);
      setToken(jwtToken);

      localStorage.setItem("User", JSON.stringify(decoded));
      localStorage.setItem("authToken", jwtToken);
    } catch (err) {
      console.error("Error en login:", err);
      setError(err);
      throw err;
    }
  };

  const logout = () => {
    try {
      setUser(null);
      setToken(null);
      localStorage.removeItem("User");
      localStorage.removeItem("authToken");
    } catch (err) {
      console.error("Logout error:", err);
      setError(err);
    }
  };

  const value = {
    user,
    token,
    setUser,
    setToken,
    login,
    logout,
    loading,
    error,
    isAuthenticated: !!user && !!token,
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
    throw new Error("useAuth must be used within an AuthProvider");
  }
  return context;
};
