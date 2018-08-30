package org.bca.training.spring.core.beans.read;

import java.util.List;
import org.bca.training.spring.core.beans.data.Model;

public interface Datasource {
  List<Model> read() throws Exception;
}
