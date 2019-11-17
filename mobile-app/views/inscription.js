import React, { Component } from 'react';
import { View, Text, TextInput, Button } from 'react-native';

import Styles from '../styles/styles';
import userService from '../services/user-service';

export default class Inscription extends Component {
    constructor (props) {
        super(props);
        this.state = {
            user: {
                nom: "",
                prenom: "",
                email: "",
                password: ""
            }
        }
    }

    static navigationOptions = ({ navigation }) => {
        return {
            title: "Inscription"
        }
    }

    render() {
        return (
            <View>
                <View>
                    <Text style={Styles.label}>Nom</Text>
                    <TextInput
                        onChangeText={(text) => {this.setState({user: {nom: text}});}}
                        value={this.state.user.nom}
                        placeholder="Nom..."
                        style={Styles.input}
                    />
                </View>
                <View>
                    <Text style={Styles.label}>Prenom</Text>
                    <TextInput
                        onChangeText={(text) => {this.setState({user: {prenom: text}});}}
                        value={this.state.user.prenom}
                        placeholder="Prenom..."
                        style={Styles.input}
                    />
                </View>
                <View>
                    <Text style={Styles.label}>Email</Text>
                    <TextInput
                        onChangeText={(text) => {this.setState({user: {email: text}});}}
                        value={this.state.user.email}
                        placeholder="Email..."
                        style={Styles.input}
                        keyboardType="email-address"
                    />
                </View>
                <View>
                    <Text style={Styles.label}>Mot de passe</Text>
                    <TextInput
                        onChangeText={(text) => {this.setState({user: {password: text}});}}
                        value={this.state.password}
                        placeholder="Mot de passe..."
                        secureTextEntry={true}
                        style={Styles.input}
                        autoCapitalize="none"
                    />
                </View>
                <Button
                    onPress={() => {userService.inscription(this.state.user);}}
                    title="Inscription"
                />
            </View>
        )
    }
}