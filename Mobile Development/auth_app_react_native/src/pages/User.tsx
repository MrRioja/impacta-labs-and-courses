import React from 'react';
import { useNavigation, useRoute } from '@react-navigation/native';
import { Button, Dimensions, TextInput, StyleSheet, Text, View, Alert } from 'react-native';

import { userService } from '../services/user.service';

export default function User() {

    const route = useRoute();
    const navigation = useNavigation<any>();

    let id = null;

    if (route.params) {
        const { userId } = route.params as any;
        id = userId;
        // userService.get(id).then((retorno) => {
        //     Alert.alert('User: '+retorno.name);
        // });
    }

    const [name, setName] = React.useState('');
    const [username, setUsername] = React.useState('');
    const [password, setPassword] = React.useState('');
    const [confirmPass, setConfirmPass] = React.useState('');

    async function save() {
        if (!name || name.trim() === '') {
            Alert.alert('Nome é obrigatório!');
        
        } else if (!username || username.trim() === '') {
            Alert.alert('Login é obrigatório!');
        
        } else if (!password || password.trim() === '' || password !== confirmPass) {
            Alert.alert('Senha não confere!');
        
        } else {
            await userService.create({ name, username, password });
            navigation.goBack();
        }
    }

    return (
        <View style={styles.container}>            
            <Text style={styles.label}>Nome:</Text>
            <TextInput style={styles.input} value={name} onChangeText={setName} />
            
            <Text style={styles.label}>Login:</Text>
            <TextInput style={styles.input} value={username} onChangeText={setUsername} editable={id === null} />
            
            <Text style={styles.label}>Senha:</Text>
            <TextInput style={styles.input} value={password} onChangeText={setPassword} secureTextEntry />

            <Text style={styles.label}>Confirmar Senha:</Text>
            <TextInput style={styles.input} onChangeText={setConfirmPass} secureTextEntry />

            <View style={styles.button}>
                <Button title='Salvar' onPress={save} />
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
    },
    label: {
        fontSize: 18,
        marginTop: 20,
        marginBottom: 5,
    },
    input: {
        width: Dimensions.get('screen').width - 80,
        height: 40,
        borderWidth: 1,
        borderRadius: 4,
    },
    button: {
        marginTop: 40,
        width: Dimensions.get('screen').width - 80
    },
});
