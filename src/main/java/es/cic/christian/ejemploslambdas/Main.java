/*
 * Copyright 2017 cmunoz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.cic.christian.ejemploslambdas;

import java.util.logging.Logger;

/**
 * @Autor cmunoz
 * @Fecha 22-jun-2017
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String args[]) {
        StreamFactory ejemploStreams = new StreamFactory();

//        ejemploStreams.streamsNumeros();
        ejemploStreams.streamsPalabras();
    }

}
