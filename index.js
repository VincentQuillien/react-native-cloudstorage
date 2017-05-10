'use strict'

import { NativeModules, Platform } from 'react-native'
// name as defined via ReactContextBaseJavaModule's getName

const CloudStorage = Platform.OS === 'ios' ? NativeModules.RNICloudStorage : NativeModules.CloudStorage

export default CloudStorage;
