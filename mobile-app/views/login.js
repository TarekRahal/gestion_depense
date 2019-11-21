import React, { Component } from 'react';
import { View, Text, TextInput, Button, KeyboardAvoidingView } from 'react-native';

import UserService from '../services/user-service';

import Styles from '../styles/styles'

export default class Login extends Component {
    static navigationOptions = ({navigation}) => {
        return {
            title: "Login"
        }
    }

    constructor(props) {
        super(props);
        this.state = {
            login: "",
            password: "",
            errorMessage: ""
        }
    }

    login(email, password) {
        this.UserService.validateLogin(email, password)
        .then((response) => response.json)
        .then((responseJson) => {
            this.props.navigation.replace("Home", {user: responseJson}, null);
        }).catch((error) => { this.setState({errorMessage: error})});
    }

    render() {
        return (
            <KeyboardAvoidingView style={Styles.container}>
                <View>
                    <Text style={Styles.label}>Email/Nom d'utilisateur</Text>
                    <TextInput
                        onChangeText={(text) => {this.setState({login: text});}}
                        value={this.state.login}
                        placeholder="email/nom d'utilisateur..."
                        style={Styles.input}
                        keyboardType="email-address"
                        autoCapitalize="none"
                    />
                </View>
                <View>
                    <Text style={Styles.label}>Mot de passe</Text>
                    <TextInput
                        onChangeText={(text) => {this.setState({password: text});}}
                        value={this.state.password}
                        placeholder="Mot de passe..."
                        secureTextEntry={true}
                        style={Styles.input}
                        autoCapitalize="none"
                    />
                </View>
                <Text style={Styles.error}>{this.state.errorMessage}</Text>
                <Button
                    onPress={this.login(this.state.login, this.state.password)}
                    title="Connexion"
                />
                <Text
                    onPress={() => {this.props.navigation.push("Inscription")}}
                    style={Styles.anchor}
                >Insciption</Text>
            </KeyboardAvoidingView>
        )
    }
}
