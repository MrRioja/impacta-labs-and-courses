import React from 'react';
import { Alert, Button, Dimensions, FlatList, StyleSheet, Text, View } from 'react-native';
import { useNavigation } from '@react-navigation/native';

import { userService } from '../services/user.service';

export default function Home() {

    const [refreshing, setRefreshing] = React.useState(false);
    const [users, setUsers] = React.useState<any[]>([]);

    const navigation = useNavigation<any>();

    navigation.setOptions({
        headerLeft: () => <Button title="Sair" onPress={() => navigation.goBack()}></Button>,
        headerRight: () => <Button title="Add" onPress={() => navigation.navigate('User')}></Button>
    });

    React.useEffect(() => {
        fetchUsers();
    }, []);

    async function fetchUsers() {
        setRefreshing(true);
        try {
            const list = await userService.getList();
            setUsers(list);    
        } catch (error) {
            navigation.goBack();
        }
        setRefreshing(false);
    }

    function goEditUser(user: any) {
        navigation.navigate('User', { userId: user.id });
    }

    return (
        <View style={styles.container}>
            <FlatList
                onRefresh={fetchUsers}
                refreshing={refreshing}
                data={users}
                renderItem={({ item }) => 
                    <View style={styles.itemView} onTouchEnd={() => goEditUser(item)}>
                        <Text>{item.name} - {item.username}</Text>
                    </View>
                }
            />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    itemView: {
        height: 50,
        borderBottomWidth: 1,
        borderBottomColor: 'gray',
        paddingHorizontal: 20,
        justifyContent: 'center',
        width: Dimensions.get('screen').width,
    },
});