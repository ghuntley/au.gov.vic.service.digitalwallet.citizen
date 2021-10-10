package net.minidev.json.writer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArraysMapper<T> extends JsonReaderI<T> {
    public static JsonReaderI<Boolean[]> MAPPER_BOOL = new ArraysMapper<Boolean[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass16 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public Boolean[] convert(Object obj) {
            List list = (List) obj;
            Boolean[] boolArr = new Boolean[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Boolean) {
                        boolArr[i] = Boolean.valueOf(((Boolean) obj2).booleanValue());
                    } else if (obj2 instanceof Number) {
                        boolArr[i] = Boolean.valueOf(((Number) obj2).intValue() != 0);
                    } else {
                        throw new RuntimeException("can not convert " + obj2 + " toBoolean");
                    }
                    i++;
                }
            }
            return boolArr;
        }
    };
    public static JsonReaderI<Byte[]> MAPPER_BYTE = new ArraysMapper<Byte[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass6 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public Byte[] convert(Object obj) {
            List list = (List) obj;
            Byte[] bArr = new Byte[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Byte) {
                        bArr[i] = (Byte) obj2;
                    } else {
                        bArr[i] = Byte.valueOf(((Number) obj2).byteValue());
                    }
                    i++;
                }
            }
            return bArr;
        }
    };
    public static JsonReaderI<Character[]> MAPPER_CHAR = new ArraysMapper<Character[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass8 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public Character[] convert(Object obj) {
            List list = (List) obj;
            Character[] chArr = new Character[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    chArr[i] = Character.valueOf(obj2.toString().charAt(0));
                    i++;
                }
            }
            return chArr;
        }
    };
    public static JsonReaderI<Double[]> MAPPER_DOUBLE = new ArraysMapper<Double[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass14 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public Double[] convert(Object obj) {
            List list = (List) obj;
            Double[] dArr = new Double[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Double) {
                        dArr[i] = (Double) obj2;
                    } else {
                        dArr[i] = Double.valueOf(((Number) obj2).doubleValue());
                    }
                    i++;
                }
            }
            return dArr;
        }
    };
    public static JsonReaderI<Float[]> MAPPER_FLOAT = new ArraysMapper<Float[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass12 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public Float[] convert(Object obj) {
            List list = (List) obj;
            Float[] fArr = new Float[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Float) {
                        fArr[i] = (Float) obj2;
                    } else {
                        fArr[i] = Float.valueOf(((Number) obj2).floatValue());
                    }
                    i++;
                }
            }
            return fArr;
        }
    };
    public static JsonReaderI<Integer[]> MAPPER_INT = new ArraysMapper<Integer[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass2 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public Integer[] convert(Object obj) {
            List list = (List) obj;
            Integer[] numArr = new Integer[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Integer) {
                        numArr[i] = (Integer) obj2;
                    } else {
                        numArr[i] = Integer.valueOf(((Number) obj2).intValue());
                    }
                    i++;
                }
            }
            return numArr;
        }
    };
    public static JsonReaderI<Long[]> MAPPER_LONG = new ArraysMapper<Long[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass10 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public Long[] convert(Object obj) {
            List list = (List) obj;
            Long[] lArr = new Long[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Float) {
                        lArr[i] = (Long) obj2;
                    } else {
                        lArr[i] = Long.valueOf(((Number) obj2).longValue());
                    }
                    i++;
                }
            }
            return lArr;
        }
    };
    public static JsonReaderI<boolean[]> MAPPER_PRIM_BOOL = new ArraysMapper<boolean[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass15 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public boolean[] convert(Object obj) {
            List<Boolean> list = (List) obj;
            boolean[] zArr = new boolean[list.size()];
            int i = 0;
            for (Boolean bool : list) {
                zArr[i] = bool.booleanValue();
                i++;
            }
            return zArr;
        }
    };
    public static JsonReaderI<byte[]> MAPPER_PRIM_BYTE = new ArraysMapper<byte[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass5 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public byte[] convert(Object obj) {
            List<Number> list = (List) obj;
            byte[] bArr = new byte[list.size()];
            int i = 0;
            for (Number number : list) {
                bArr[i] = number.byteValue();
                i++;
            }
            return bArr;
        }
    };
    public static JsonReaderI<char[]> MAPPER_PRIM_CHAR = new ArraysMapper<char[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass7 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public char[] convert(Object obj) {
            List<Object> list = (List) obj;
            char[] cArr = new char[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                cArr[i] = obj2.toString().charAt(0);
                i++;
            }
            return cArr;
        }
    };
    public static JsonReaderI<double[]> MAPPER_PRIM_DOUBLE = new ArraysMapper<double[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass13 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public double[] convert(Object obj) {
            List<Number> list = (List) obj;
            double[] dArr = new double[list.size()];
            int i = 0;
            for (Number number : list) {
                dArr[i] = number.doubleValue();
                i++;
            }
            return dArr;
        }
    };
    public static JsonReaderI<float[]> MAPPER_PRIM_FLOAT = new ArraysMapper<float[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass11 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public float[] convert(Object obj) {
            List<Number> list = (List) obj;
            float[] fArr = new float[list.size()];
            int i = 0;
            for (Number number : list) {
                fArr[i] = number.floatValue();
                i++;
            }
            return fArr;
        }
    };
    public static JsonReaderI<int[]> MAPPER_PRIM_INT = new ArraysMapper<int[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass1 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public int[] convert(Object obj) {
            List<Number> list = (List) obj;
            int[] iArr = new int[list.size()];
            int i = 0;
            for (Number number : list) {
                iArr[i] = number.intValue();
                i++;
            }
            return iArr;
        }
    };
    public static JsonReaderI<long[]> MAPPER_PRIM_LONG = new ArraysMapper<long[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass9 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public long[] convert(Object obj) {
            List<Number> list = (List) obj;
            long[] jArr = new long[list.size()];
            int i = 0;
            for (Number number : list) {
                jArr[i] = (long) number.intValue();
                i++;
            }
            return jArr;
        }
    };
    public static JsonReaderI<short[]> MAPPER_PRIM_SHORT = new ArraysMapper<short[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass3 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public short[] convert(Object obj) {
            List<Number> list = (List) obj;
            short[] sArr = new short[list.size()];
            int i = 0;
            for (Number number : list) {
                sArr[i] = number.shortValue();
                i++;
            }
            return sArr;
        }
    };
    public static JsonReaderI<Short[]> MAPPER_SHORT = new ArraysMapper<Short[]>(null) {
        /* class net.minidev.json.writer.ArraysMapper.AnonymousClass4 */

        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public Short[] convert(Object obj) {
            List list = (List) obj;
            Short[] shArr = new Short[list.size()];
            int i = 0;
            for (Object obj2 : list) {
                if (obj2 != null) {
                    if (obj2 instanceof Short) {
                        shArr[i] = (Short) obj2;
                    } else {
                        shArr[i] = Short.valueOf(((Number) obj2).shortValue());
                    }
                    i++;
                }
            }
            return shArr;
        }
    };

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.minidev.json.writer.JsonReaderI
    public T convert(Object obj) {
        return obj;
    }

    public ArraysMapper(JsonReader jsonReader) {
        super(jsonReader);
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public Object createArray() {
        return new ArrayList();
    }

    @Override // net.minidev.json.writer.JsonReaderI
    public void addValue(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }

    public static class GenericMapper<T> extends ArraysMapper<T> {
        final Class<?> componentType;
        JsonReaderI<?> subMapper;

        public GenericMapper(JsonReader jsonReader, Class<T> cls) {
            super(jsonReader);
            this.componentType = cls.getComponentType();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object[]] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // net.minidev.json.writer.ArraysMapper, net.minidev.json.writer.JsonReaderI
        public T convert(Object obj) {
            List<Object> list = (List) obj;
            ?? r0 = (T) ((Object[]) Array.newInstance(this.componentType, list.size()));
            int i = 0;
            for (Object obj2 : list) {
                r0[i] = obj2;
                i++;
            }
            return r0;
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startArray(String str) {
            if (this.subMapper == null) {
                this.subMapper = this.base.getMapper((Class) this.componentType);
            }
            return this.subMapper;
        }

        @Override // net.minidev.json.writer.JsonReaderI
        public JsonReaderI<?> startObject(String str) {
            if (this.subMapper == null) {
                this.subMapper = this.base.getMapper((Class) this.componentType);
            }
            return this.subMapper;
        }
    }
}
