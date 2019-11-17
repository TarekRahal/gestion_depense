import Inscription from "../views/inscription";

export default UserService = {
    users: [
        {
            id: 0,
            nom: "Osterone",
            prenom: "Test",
            email: "test@test.test",
            password: "qwerty"
        },
        {
            id: 1,
            nom: "Test",
            prenom: "Jhony",
            email: "tester@email.com",
            password: "azerty"
        }
    ],

    getUserByEmail: (email) => {
        var returnedUser = null;
        UserService.users.forEach((user) => {
            if (user.email === email) {
                returnedUser = user;
            }
        });

        if (returnedUser === null) {
            return {errorMessage: "email introuvable"};
        } else {
            return returnedUser;
        }
    },

    login: (email, password) => {
        // le code ici est provisoire 
        // envoyer une requete de connexion au serveur avec l'email et le mot de passe entre
        var user = UserService.getUserByEmail(email);
        if (user.password === password) {
            return true;
        } else {
            return false;
        }
    },

    inscription: (user) => {
        // envoyer une requete d'inscription au serveur avec les donnees de l'utilisateur
    }
}