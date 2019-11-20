import React, { Component } from 'react';
import { View, Text } from 'react-native';

import Styles from '../styles/styles';

export default class Profile extends Component {
    render() {
        return (
            <View style={Styles.container}>
                <Text>Vue Profile</Text>
            </View>
        )
    }
}