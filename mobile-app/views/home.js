import React, { Component } from 'react';
import { View, Text, TextInput, KeyboardAvoidingView, Picker, Button } from 'react-native';
import RNDateTimePicker from '@react-native-community/datetimepicker';

import UserService from '../services/user-service';

import Styles from '../styles/styles';

export default class Home extends Component {
    constructor (props) {
        super(props);
        this.state = {
            user: UserService.getUserByEmail(this.props.navigation.getParam("email")),
            totalDepense: 0,
            depenseAjoutee: {
                categorie: "alimentation",
                valeur: 0,
                date: new Date(),
                description: ""
            }
        }
    }

    componentDidMount() {
        this.props.navigation.setParams({title: this.state.user.prenom + " " + this.state.user.nom});
        this.setState({totalDepense: UserService.getTotalDepenses(this.state.user.id, new Date())});
    }

    static navigationOptions = ({navigation}) => {
        return {
            title: navigation.getParam("title", "Page d'acceuil")
        };
    }

    render() {
        return (
            <View style={Styles.container}>
                <Text>Credit: {this.state.user.credit}</Text>
                <Text>Depense d'aujourd'hui: {this.state.totalDepense}</Text>
                <KeyboardAvoidingView>
                    <View>
                        <Text style={Styles.label}>Categorie</Text>
                        <Picker
                            selectedValue={this.state.depenseAjoutee.categorie}
                            onValueChange={(itemValue, itemIndex) => {
                                this.setState({depenseAjoutee: {categorie: itemValue}});
                            }}
                            style={Styles.input}
                        >
                            <Picker.Item label="Alimentation" value="alimentation" />
                            <Picker.Item label="Transport" value="transport" />
                            <Picker.Item label="Loisir" value="loisir" />
                            <Picker.Item label="Education" value="education" />
                        </Picker>
                    </View>
                    <View>
                        <Text style={Styles.label}>Valeur</Text>
                        <TextInput
                            onChangeText={(text) => {this.setState({depenseAjoutee: {valeur: text}})}}
                            keyboardType="numeric"
                            placeholder="Valeur..."
                            style={Styles.input}
                            value={this.state.depenseAjoutee.valeur}
                        />
                    </View>
                    <View>
                        <Text style={Styles.label}>Date</Text>
                        
                    </View>
                    <View>
                        <Text style={Styles.label}>Description</Text>
                        <TextInput
                            value={this.state.depenseAjoutee.description}
                            onChangeText={(text) => {this.setState({depenseAjoutee: {description: text}})}}
                            placeholder="Description..."
                            style={Styles.input}
                        />
                    </View>
                    <Button
                        title="Ajouter Depense"
                        onPress={() => {UserService.ajouterDepense(this.state.depenseAjoutee)}}
                    />
                </KeyboardAvoidingView>
            </View>
        )
    }
}