import api from "../../api";

export const loginUser = async (email, password) => {
  const response = await api.post('/auth/authenticate', { email, password });
  return response.data; 
};

export const registerUser = async (userData) => {
  try {
    console.log("Payload registro:", userData);

    const response = await fetch("http://localhost:8080/auth/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(userData),
    });

    if (!response.ok) {
      const errorData = await response.json();
      console.error("Error backend registro:", errorData);
      throw new Error(errorData.message || "Error en registro");
    }

    return await response.json();
  } catch (err) {
    console.error("Error en registerUser:", err);
    throw err;
  }
};

