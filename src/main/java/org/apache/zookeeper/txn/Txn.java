// File generated by hadoop record compiler. Do not edit.
/**
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.apache.zookeeper.txn;

import org.apache.jute.*;

public class Txn implements Record {
  private int type;
  private byte[] data;
  public Txn() {
  }
  public Txn(
        int type,
        byte[] data) {
    this.type=type;
    this.data=data;
  }
  public int getType() {
    return type;
  }
  public void setType(int m_) {
    type=m_;
  }
  public byte[] getData() {
    return data;
  }
  public void setData(byte[] m_) {
    data=m_;
  }
  public void serialize(OutputArchive a_, String tag) throws java.io.IOException {
    a_.startRecord(this,tag);
    a_.writeInt(type,"type");
    a_.writeBuffer(data,"data");
    a_.endRecord(this,tag);
  }
  public void deserialize(InputArchive a_, String tag) throws java.io.IOException {
    a_.startRecord(tag);
    type=a_.readInt("type");
    data=a_.readBuffer("data");
    a_.endRecord(tag);
}
  public String toString() {
    try {
      java.io.ByteArrayOutputStream s =
        new java.io.ByteArrayOutputStream();
      CsvOutputArchive a_ = 
        new CsvOutputArchive(s);
      a_.startRecord(this,"");
    a_.writeInt(type,"type");
    a_.writeBuffer(data,"data");
      a_.endRecord(this,"");
      return new String(s.toByteArray(), "UTF-8");
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
    return "ERROR";
  }
  public void write(java.io.DataOutput out) throws java.io.IOException {
    BinaryOutputArchive archive = new BinaryOutputArchive(out);
    serialize(archive, "");
  }
  public void readFields(java.io.DataInput in) throws java.io.IOException {
    BinaryInputArchive archive = new BinaryInputArchive(in);
    deserialize(archive, "");
  }
  public int compareTo (Object peer_) throws ClassCastException {
    if (!(peer_ instanceof Txn)) {
      throw new ClassCastException("Comparing different types of records.");
    }
    Txn peer = (Txn) peer_;
    int ret = 0;
    ret = (type == peer.type)? 0 :((type<peer.type)?-1:1);
    if (ret != 0) return ret;
    {
      byte[] my = data;
      byte[] ur = peer.data;
      ret = org.apache.jute.Utils.compareBytes(my,0,my.length,ur,0,ur.length);
    }
    if (ret != 0) return ret;
     return ret;
  }
  public boolean equals(Object peer_) {
    if (!(peer_ instanceof Txn)) {
      return false;
    }
    if (peer_ == this) {
      return true;
    }
    Txn peer = (Txn) peer_;
    boolean ret = false;
    ret = (type==peer.type);
    if (!ret) return ret;
    ret = org.apache.jute.Utils.bufEquals(data,peer.data);
    if (!ret) return ret;
     return ret;
  }
  public int hashCode() {
    int result = 17;
    int ret;
    ret = (int)type;
    result = 37*result + ret;
    ret = java.util.Arrays.toString(data).hashCode();
    result = 37*result + ret;
    return result;
  }
  public static String signature() {
    return "LTxn(iB)";
  }
}
