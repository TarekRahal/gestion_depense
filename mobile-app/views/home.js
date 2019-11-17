import React, { Component } from 'react';
import { View, Text } from 'react-native';

import UserService from '../services/user-service'

export default class Home extends Component {
    constructor (props) {
        super(props);
        this.state = {
            user: UserService.getUserByEmail(this.props.navigation.getParam("email"))
        }
    }

    componentDidMount() {
        this.props.navigation.setParams({title: this.state.user.prenom + " " + this.state.user.nom});
    }

    static navigationOptions = ({navigation}) => {
        return {
            title: navigation.getParam("title", "Page d'acceuil")
        };
    }

    render() {
        return (
            <View>
                <Text>Page d'acceuil</Text>
            </View>
        )
    }
}