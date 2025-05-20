export const mockUsers = [
  {
    email: "ramiroflojo@gmail.com",
    passwordHash: "perro",
    phoneNumber: "+529999888777",
    name: "Pecezon",
    lastname: "JIJIJIJI",
    address: "calle 4",
  },
  {
    email: "ramirogei@gmail.com",
    passwordHash: "perro",
    phoneNumber: "+529999888777",
    name: "joto",
    lastname: "JIJIJIJI",
    address: "calle 5",
  },
];

export const mockAuthApi = {
  login: (email, password) => {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        const user = mockUsers.find(
          (user) => user.email === email && user.passwordHash === password
        );
        
        if (user) {
          const mockToken = `mock-token-${Math.random().toString(36).substring(2)}`;
          resolve({ user, token: mockToken });
        } else {
          reject(new Error("Invalid credentials"));
        }
      }, 500); 
    });
  },

  signup: (userData) => {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        const emailExists = mockUsers.some(user => user.email === userData.email);
        
        if (emailExists) {
          reject(new Error("Email already exists"));
        } else {
          const newUser = {
            ...userData,
            passwordHash: userData.password
          };
          mockUsers.push(newUser);
          
          const mockToken = `mock-token-${Math.random().toString(36).substring(2)}`;
          resolve({ user: newUser, token: mockToken });
        }
      }, 500);
    });
  }
};
