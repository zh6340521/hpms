package hpms.bs.mapper;

import com.hand.hap.account.dto.Role;
import com.hand.hap.mybatis.common.Mapper;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import hpms.bs.dto.DataPriviliage;
import java.util.List;

public interface DataPriviliageMapper extends Mapper<DataPriviliage>{
    List<DataPriviliage> queryDataPriviliage(DataPriviliage dataPriviliage);

    List<Role> roleQuery(Role role);

}