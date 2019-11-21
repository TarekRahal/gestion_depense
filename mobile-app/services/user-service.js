export default UserService = {
    // mock data for tests
    // felt useful, may delete later, idk...
    users: [
        {
            id: 0,
            nom: "Osterone",
            prenom: "Test",
            email: "test@test.test",
            password: "qwerty",
            credit: 885.42,
            depenses: [
                {
                    id: 0,
                    categorie: "alimentattion",
                    valeur: 28,
                    date: new Date(2019, 10, 18, 13, 23),
                    description: "Despacito 3nd Cosa Mia"
                },
                {
                    id: 1,
                    categorie: "transport",
                    valeur: 10,
                    date: new Date(2019, 10, 18, 18, 39),
                    description: "taxi l dar"
                }
            ]
        },
        {
            id: 1,
            nom: "Test",
            prenom: "Jhony",
            email: "tester@email.com",
            password: "azerty",
            credit: 1271.13,
            depenses: [
                {
                    id: 0,
                    categorie: "alimentattion",
                    valeur: 30,
                    date: new Date(2019, 10, 18, 13, 23),
                    description: "1/4 poulet grille chez Taoufik"
                },
                {
                    id: 1,
                    categorie: "transport",
                    valeur: 10,
                    date: new Date(2019, 10, 18, 18, 39),
                    description: "taxi l dar"
                },
                {
                    id: 2,
                    categorie: "sante",
                    valeur: 17,
                    date: new Date(2019, 10, 18, 19, 23),
                    description: "Dolyprane"
                }
            ]
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

    getTotalDepenses: (id, date) => {
        var total = 0;
        UserService.users[id].depenses.forEach((depense) => {
            if (date.toDateString() === depense.date.toDateString()) {
                total += depense.valeur;
            }
        });
        return total;
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

    validateLogin: async (email, password) => {
        return fetch("https://localhost:3030/users/validateLogin", {
            method: "POST",
            headers: {
                Accept: "application/json",
                "Content-Type": "application/json"
            },
            body: {
                username: email,
                password
            }
        });
    },

    inscription: (user) => {
        // envoyer une requete d'inscription au serveur avec les donnees de l'utilisateur
    },

    ajouterDepense: (depense) => {
        // ajouter depense
    }
}