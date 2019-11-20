//This is an example code for PieChart//
import React, { Component } from 'react';
//import react in our code.
import { StyleSheet, View, Text } from 'react-native';
// import all basic components
import Pie from 'react-native-pie';
// import pie to make pie chart

export default class App extends Component {
  render() {
    return (
      <View style={styles.container}>
      <Text>bilan des depenses</Text>
        <Pie
          radius={70}
          series={[56, 11, 77]}
          colors={['yellow', 'green', 'orange']}
        />
        <Text>Solid/Filled Pie Chart</Text>
        <Pie
          radius={70}
          innerRadius={40}
          series={[10, 20, 30, 40]}
          colors={['#f00', '#0f0', '#00f', '#ff0']}
        />
        <Text>Donut Pie Chart</Text>
        <View>
          <Pie
            radius={70}
            innerRadius={65}
            series={[55]}
            colors={['#f00']}
            backgroundColor="#ddd"
          />
          <View style={styles.gauge}>
            <Text style={styles.gaugeText}>55%</Text>
          </View>
          <Text>Gauge Pie Chart</Text>
        </View>
      </View>
    );
  }
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'space-around',
    marginTop:30,
  },
  gauge: {
    position: 'absolute',
    width: 140,
    height: 140,
    alignItems: 'center',
    justifyContent: 'center',
  },
  gaugeText: {
    backgroundColor: 'transparent',
    color: '#000',
    fontSize: 24,
  },
});
