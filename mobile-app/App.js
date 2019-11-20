import React from 'react';
import { createAppContainer } from 'react-navigation';
import { createStackNavigator } from 'react-navigation-stack';

// importation des vues
import Inscription from './views/inscription';
import Login from './views/login';
import Home from './views/home';
import Profile from './views/profile';
import AjouterDepense from './views/ajouterDepense';
import AjouterRevenu from './views/ajouterRevenu';
import ModiferProfil from './views/modifierProfil';
import DepenseParDate from './views/graph-depense-par-date';
import DepenseParCategorie from './views/graph-depense-par-categorie';

const AuthNavigator = createStackNavigator(
  {
    Login: {screen: Login},
    Inscription: {screen: Inscription}
  }
);

const HomeNavigator = createStackNavigator(
  {
    HomeScreen: {screen: Home},
    AjouterDepense: {screen: AjouterDepense}
  },
  {
    defaultNavigationOptions: {
      headerStyle: {
        backgroundColor: '#FFE4C4'
      },
      headerTintColor: '#6495ED',
      headerTitleStyle: {
        fontWeight: 'bold'
      }
    }
  }
);

const ProfileNavigator = createStackNavigator(
  {
    Profile: {screen: Profile},
    ModifierProfil: {screen: ModiferProfil},
    AjouterRevenu: {screen: AjouterRevenu}
  },
  {
    defaultNavigationOptions: {
      headerStyle: {
        backgroundColor: '#FFE4C4'
      },
      headerTintColor: '#6495ED',
      headerTitleStyle: {
        fontWeight: 'bold'
      }
    }
  }
);

const UserNavigator = createStackNavigator(
  {
    Home: {screen: HomeNavigator},
    Profile: {screen: ProfileNavigator}
  },
  {
    headerMode: 'none',
  }
);

const MainNavigator = createStackNavigator(
  {
    Authentification: {screen: AuthNavigator},
    User: {screen: UserNavigator}
  },
  {
    headerMode: 'none',
  }
);

const AppContainer = createAppContainer(MainNavigator);

export default function App() {
  return (
    <AppContainer></AppContainer>
  );
}
