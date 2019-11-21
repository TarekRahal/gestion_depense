import { StyleSheet } from 'react-native';

export default styles = StyleSheet.create({

    view1: {
        flexDirection: 'column',
        justifyContent: 'space-between',
    
    },

    buttonStyle: {
      color: 'red',
      marginTop: 20,
      padding: 20,
      backgroundColor: 'green'
  },
  
    container: {
      flex: 1,
      backgroundColor: '#123f',
      alignItems: 'center',
      justifyContent:'center',
     
      
    },
    label: {
    
      textAlign: 'center',
      fontSize: 16,
      color: '#FFF',
      
      
    },
    input: {
      borderRadius: 5,
      backgroundColor: '#FFF',
      marginLeft: 5,
      marginRight: 5,
      borderColor: '#000000',
      borderWidth: 1,
      paddingLeft: 5,
      width: 200, 
      height: 40,
    },
    error: {
      color: 'red',
      fontSize: 20
    },
    anchor: {
      color: 'blue',
      textDecorationLine: 'underline',
   
  
    }
  });