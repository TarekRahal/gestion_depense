import { StyleSheet } from 'react-native';

export default styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      alignItems: 'center',
      justifyContent: 'center',
    },
    label: {
      textAlign: 'center',
      fontSize: 16,
      color: '#6495ED'
    },
    input: {
      borderRadius: 5,
      backgroundColor: '#FFF8DC'
    },
    error: {
      color: 'red',
      fontSize: 11
    },
    anchor: {
      color: 'blue',
      textDecorationLine: 'underline'
    }
  });